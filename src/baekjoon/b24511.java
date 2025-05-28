package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] A = br.readLine().split(" ");
        String[] x = br.readLine().split(" ");
        Queue<String> q = new LinkedList<>();
        for (int i = N-1; i >= 0; i--) {
            if(A[i].equals("0")){
                q.add(x[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        String[] C = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        if(!q.isEmpty()) {
            for (int i = 0; i < M; i++) {
                sb.append(q.remove()).append(" ");
                q.add(C[i]);
            }
        }else{
            for(int i = 0; i < M; i++){
                sb.append(C[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
