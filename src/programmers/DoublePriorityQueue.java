package programmers;

import java.util.*;

public class  DoublePriorityQueue{
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> reverse = new PriorityQueue<>(Comparator.reverseOrder());
        for (String string : operations) {
            String[] s = string.split(" ");
            if (Objects.equals(s[0], "I")) {
                int n = Integer.parseInt(s[1]);
                queue.add(n);
                reverse.add(n);
            }
            else {
                if(queue.isEmpty()) continue;
                if (Objects.equals(s[1], "1")) {
                    queue.remove(reverse.poll());
                }
                else{
                    reverse.remove(queue.poll());
                }
            }
        }
        if (queue.isEmpty()) {
            Arrays.fill(answer, 0);
        } else {
            answer[0] = reverse.poll();
            answer[1] = queue.poll();
        }
        return answer;
    }
}
