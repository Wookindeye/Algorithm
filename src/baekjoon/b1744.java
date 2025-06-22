package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] < 0){
                if(i+1 < n && arr[i+1] <= 0) {
                    result += arr[i] * arr[i + 1];
                    i++;
                }else{
                    result += arr[i];
                }
            }
            else if(arr[i]==0) continue;
            else if(arr[i] == 1){
                result ++;
            }
            else break;
        }
        for (int i = n-1; i >= 0; i--) {
            if(arr[i] <= 1) break;
            if( arr[i-1] <= 1) {
                result += arr[i];
                break;
            } else {
                result += arr[i] * arr[i - 1];
                i--;
            }
        }
        System.out.println(result);
    }
}
