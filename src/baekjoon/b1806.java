package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = 100000;
        int l = 0, r = 0;
        int sum = 0;
        while (true) {
            if(sum < m){
                if(r == n) break;
                sum += arr[r];
                r++;
            }else {
                min = Math.min(min, r - l);
                sum -= arr[l];
                l++;
            }
        }
        System.out.println(min == 100000 ? 0 : min);
    }

}
