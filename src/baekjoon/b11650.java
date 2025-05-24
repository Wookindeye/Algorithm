package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class b11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(arr, (ints, t1) -> {
            if(ints[0] == t1[0]){
                return ints[1] - t1[1];
            } else return ints[0] - t1[0];
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int[] ints : arr) {
            bw.write(ints[0] + " " + ints[1] + "\n");
        }
        bw.flush();
    }
}
