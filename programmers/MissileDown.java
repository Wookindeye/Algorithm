package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class MissileDown {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));
        int n = targets[0][1];
        for (int i = 1; i < targets.length; i++) {
            if (targets[i][0] >= n) {
                answer++;
                n = targets[i][1];
            }
        }
        return answer+1;
    }
}
