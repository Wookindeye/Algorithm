package programmers;

import java.util.HashSet;
import java.util.Set;

public class LottoMinMax {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> winset = new HashSet<>();
        for(int i : win_nums) winset.add(i);
        int wins =0;
        int zero =0;
        for(int i : lottos) {
            if(winset.contains(i)) wins++;
            else if(i == 0) zero++;
        }
        answer[0] = rank(wins+zero);
        answer[1] = rank(wins);

        return answer;
    }
    public int rank(int win){
        return switch (win) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
