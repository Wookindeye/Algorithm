package programmers;

public class MatchList {
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while (a != b) {
            a = (int) Math.ceil((double) a / 2);
            b = (int) Math.ceil((double)b / 2);
            answer++;
        }
        return answer;
    }
}
