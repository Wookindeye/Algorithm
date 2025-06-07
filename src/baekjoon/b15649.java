package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        boolean[] visit = new boolean[n];
        recursive(visit,m,0,"");
    }

    static void recursive(boolean[] visit, int m, int dep, String s) {
        if(dep == m){
            System.out.println(s);
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            if(!visit[i]){
                String s1 = s + (i + 1) + " ";
                boolean[] next = visit.clone();
                next[i] = true;
                recursive(next, m, dep + 1, s1);
            }
        }
    }
}
