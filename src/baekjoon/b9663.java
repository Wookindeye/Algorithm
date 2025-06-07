package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9663 {
    static boolean[][] chess;
    static int n;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        chess = new boolean[n][n];
        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, i)) {
                chess[row][i] = true;
                dfs(row + 1);
                chess[row][i] = false;
            }
        }
    }
    static boolean isValid(int y, int x){
        for (int i = 0; i < y; i++) {
            if(chess[i][x]) return false;
        }
        for(int i = 1; i < chess.length; i++){
            if( y - i >= 0 && x - i >= 0 && chess[y-i][x-i] ) return false;
            if( y - i >= 0 && x + i < chess.length && chess[y-i][x+i]) return false;
        }
        return true;
    }
}
