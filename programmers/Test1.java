package programmers;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                answer[i] = -1;
                continue;
            }
            for (int j = i-1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    answer[i] = i - j;
                    break;
                }
            }
        }
        return answer;
    }
}
