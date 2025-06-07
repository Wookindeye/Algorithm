package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2447 {
    public static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        StringBuilder sb = new StringBuilder();
        recursive(N,0,0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j])
                    sb.append("*");
                else sb.append(" ");
            }
            if(i != N-1)
                sb.append("\n");
        }
        System.out.println(sb);
    }

    static void recursive(int n, int x, int y){
        if(n == 1) {
            board[x][y] = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if( i == 1 && j == 1 ) continue;
                recursive(n/3,x + n/3*i,y + n/3*j);
            }
        }
    }
}
