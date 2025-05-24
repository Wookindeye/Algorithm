package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0, number = 665;
        String sixes = "666";
        while (cnt < n) {
            number++;
            String s = ""+number;
            if (s.contains(sixes)) {
                cnt++;
            }
        }
        System.out.println(number);
    }
}
