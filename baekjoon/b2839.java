package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2839 {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = n / 5;
        while (true) {
            if (n % 5  == 0) {
                answer = min;
                break;
            }
            else {
                if ((n - 5 * min) % 3 == 0) {
                    answer = min + ((n - 5 * min) / 3);
                    break;
                }
            }
            if (min == 0) {
                answer = -1;
                break;
            }
            min--;
        }
        System.out.println(answer);
    }
}
