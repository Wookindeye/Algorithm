package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b2580 {
    static int[][] sudoku = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            sudoku[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sudoku[i][j] == 0){
                    int[] blank = {i, j};
                    blanks.add(blank);
                }
            }
        }
        dfs(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static boolean dfs(int index){
        if(index == blanks.size()){
            return true;
        }
        int x = blanks.get(index)[1];
        int y = blanks.get(index)[0];
        for (int i = 1; i <= 9; i++) {
            if (isValid(y, x, i)) {
                sudoku[y][x] = i;
                if (dfs(index + 1)) return true;
                sudoku[y][x] = 0;
            }
        }
        return false;
    }

    static boolean isValid(int y, int x, int t) {
        for (int i = 0; i < 9; i++) {
            if(sudoku[y][i] == t || sudoku[i][x] == t) return false;
        }
        for (int a = 3 * (y / 3); a < 3 * (y / 3) + 3; a++) {
            for (int b = 3 * (x / 3); b < 3 * (x / 3) + 3; b++) {
                if(sudoku[a][b] == t) return false;
            }
        }
        return true;
    }
}
