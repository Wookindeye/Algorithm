package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11729 {
    static int cnt = 0;
    static StringBuilder route = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        recursive(n,1,3);
        sb.append(cnt).append("\n").append(route);
        System.out.println(sb);
    }
    static void recursive(int n, int from, int to){
        if(n==1){
            route.append(from).append(" ").append(to).append("\n");
            cnt++;
            return;
        }
        int via = 6 - from - to;
        recursive(n-1, from, via);
        route.append(from).append(" ").append(to).append("\n");
        cnt++;
        recursive(n-1,via, to);
    }
}
