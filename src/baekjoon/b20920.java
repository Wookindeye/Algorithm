package baekjoon;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = nm[0];
        int M = nm[1];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if(s.length() < M ) continue;
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else map.put(s, 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)->{
            int cmp = a.getValue().compareTo(b.getValue());
            if(cmp == 0){
                cmp = Integer.compare(a.getKey().length(), b.getKey().length());
                if (cmp == 0) {
                    cmp = a.getKey().compareToIgnoreCase(b.getKey()) * -1;
                }
            }
            return cmp* -1;
        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> entry: list){
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
