package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b25501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            int[] result = recursion(1, s, 0, s.length() - 1);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.println(sb);
    }
    static int[] recursion(int cnt, String s, int l, int r){

        if( l >= r ) return new int[]{1,cnt};
        else if(s.charAt(l) != s.charAt(r)) return new int[]{0,cnt};

        else return recursion(cnt + 1, s, l + 1, r - 1);
    }
}
