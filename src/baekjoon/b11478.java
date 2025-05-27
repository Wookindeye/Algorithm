package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class b11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String tmp = s.substring(i,j);
                System.out.println(tmp);
                if(!tmp.isEmpty()){
                    set.add(tmp);
                }
            }
        }
        System.out.println(set.size());
    }
}
