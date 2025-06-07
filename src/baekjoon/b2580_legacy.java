package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2580_legacy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            sudoku[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sudoku[i][j] == 0) sudoku[i][j] = fill(j,i,sudoku);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int fill(int x, int y, int[][] sudoku) {

        for (int j = 1; j <= 9; j++) {
            int[][] clone = sudoku.clone();
            clone[y][x] = j;

            int horizonSum = 0;
            int verticalSum = 0;
            int squareSum = 0;

            for (int i = 0; i < 9; i++) {
                if (clone[y][i] == 0) clone[y][i] = fill(i, y, clone);
                if (clone[i][x] == 0) clone[i][x] = fill(x, i, clone);
                horizonSum += clone[y][i];
                verticalSum += clone[i][x];
            }
            for (int a = 3 * (y / 3); a < 3 * (y / 3) + 3; a++) {
                for (int b = 3 * (x / 3); b < 3 * (x / 3) + 3; b++) {
                    if(clone[a][b] == 0) clone[a][b] = fill(b, a, clone);
                    squareSum += clone[a][b];
                }
            }
            if (horizonSum == 45 && verticalSum == 45 && squareSum == 45) {
                return j;
            }
        }
        return 0;
    }

}
