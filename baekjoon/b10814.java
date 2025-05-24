package baekjoon;

import java.awt.*;
import java.io.*;
import java.util.*;

public class b10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = br.readLine();
            arr[i][1] = i + "";
        }
        Arrays.sort(arr,(o1,o2)-> {
            int n1 = Integer.parseInt(o1[0].split(" ")[0]);
            int n2 = Integer.parseInt(o2[0].split(" ")[0]);
            if(n1 == n2) return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
            else return n1 - n2;
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String[] s : arr) {
            bw.write(s[0] + "\n");
        }
        bw.flush();
    }
}
