package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2231 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int sum = i, tmp = i;
            while (tmp != 0) {
                sum += tmp %10;
                tmp /= 10;
            }
            if (sum == n) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
