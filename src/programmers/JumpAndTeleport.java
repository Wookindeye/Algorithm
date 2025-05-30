package programmers;

public class JumpAndTeleport {
    public int solution(int n) {
        int ans = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n/=2;
            }
            else {
                n--;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        JumpAndTeleport jt = new JumpAndTeleport();
        System.out.println(jt.solution(5000));
    }
}
