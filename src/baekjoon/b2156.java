package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] gls = new int[n];

        for (int i = 0; i < n; i++) {
            gls[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = gls[0];
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][1] = dp[i - 1][0] + gls[i];
            dp[i][2] = dp[i - 1][1] + gls[i];
        }
        System.out.println(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }
}
