package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;

        int l = 0, r = 0;
        int sum = 0;
        while (true) {
            if(sum >= m){
                sum -= arr[l];
                l ++;
            } else if( r== n) break;
            else {
                sum += arr[r];
                r ++;
            }
            if(sum == m){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
