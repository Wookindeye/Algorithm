package programmers;

public class DevCourse2 {
    public static void main(String[] args) {
        System.out.println(solution(1,1000000));
    }
    public static long solution(int r1, int r2) {
        long answer = 0;
        for (int i = 1; i <= r2; i++) {
            for(int j = 0; j <= r2; j++) {
                double tmp = Math.sqrt(i * i + j*j);
                if (tmp >= r1 && tmp <= r2) {
                    answer++;
                }
            }
        }
        return answer*4;
    }
}
