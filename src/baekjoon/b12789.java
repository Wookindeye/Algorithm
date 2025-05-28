package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class b12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> line = new Stack<>();
        Stack<Integer> space = new Stack<>();

        for (int i = 0; i < N; i++) {
            line.push(n[n.length - 1 - i]);
        }
        int currentTurn = 1;
        while (true) {
            if(line.isEmpty()){
                if(space.isEmpty()) break;
                else if (currentTurn != space.peek()) {
                    break;
                }
                else {
                    space.pop();
                    currentTurn++;
                }
            }else{
                if(!space.isEmpty() && space.peek() == currentTurn){
                    space.pop();
                    currentTurn++;
                }
                else{
                    if(line.peek()==currentTurn){
                        line.pop();
                        currentTurn++;
                    }else space.push(line.pop());
                }
            }
        }
        if(space.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }
}
