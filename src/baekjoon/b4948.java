package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class b4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) {
            dq.addLast(i+1);
        }
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int balloon = dq.removeFirst();
            int moves = nums[balloon-1];
            answer.append(balloon).append(" ");
            if(dq.isEmpty()) break;
            if(moves < 0){
                for(int j = 0; j < Math.abs(moves); j++){
                    int tmp = dq.removeLast();
                    dq.addFirst(tmp);
                }
            }else{
                for(int j = 0; j < moves-1; j++){
                    int tmp = dq.removeFirst();
                    dq.addLast(tmp);
                }
            }
        }
        System.out.println(answer);
    }

}
