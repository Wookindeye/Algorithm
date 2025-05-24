package programmers;

import java.util.HashSet;
import java.util.Set;

public class WordChain {
    public int[] solution(int n, String[] words) {
        int round = 0, lose = 0;
        char c = words[0].charAt(words[0].length()-1);
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != c || set.contains(words[i])) {
                round = i / n + 1;
                lose = i % n + 1;
                break;
            }
            set.add(words[i]);
            c = words[i].charAt(words[i].length() - 1);
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        return new int[]{lose,round};
    }
}
