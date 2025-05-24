package baekjoon;

import java.io.*;
import java.util.Arrays;

public class b2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] cnts = new int[10000];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            cnts[Integer.parseInt(br.readLine())-1] ++;
        }
        for (int i = 0; i < 10000; i++) {
            if (cnts[i] != 0) {
                for (int j = 0; j < cnts[i]; j++) {
                    bw.write((i+1) + "\n");
                }
            }
        }
        bw.flush();
    }
}
