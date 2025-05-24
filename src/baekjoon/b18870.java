package baekjoon;

import java.io.*;
import java.util.*;

public class b18870 {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        String[] tmp = s.clone();
        Arrays.sort(s, Comparator.comparingInt(Integer::parseInt));
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(Integer.parseInt(s[i]))) continue;
            map.put(Integer.parseInt(s[i]), idx);
            idx++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String string : tmp) {
            bw.write(map.get(Integer.parseInt(string)) + " ");
        }
        bw.flush();
    }
}
