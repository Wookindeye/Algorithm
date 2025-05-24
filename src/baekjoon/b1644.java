package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 2; i <= x; i++) {
            if (isPrime(i)) {
                array.add(i);
            }
        }
        int cnt = 0, sum = 0;
        int start = 0, end = 0;
        while (start < array.size()) {
            if (sum == x) {
                cnt ++;
                sum -= array.get(start);
                start++;
            } else if (end == array.size()) {
                sum -= array.get(start);
                start++;
            } else if (sum > x) {
                sum -= array.get(start);
                start++;
            } else if (sum < x) {
                sum += array.get(end);
                end++;
            }
        }
        System.out.println(cnt);
    }
    static boolean isPrime(int n){
        int cnt = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
