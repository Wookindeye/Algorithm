package programmers;

public class Joystick {
    public int solution(String name) {
        int answer = 0, cnt = Integer.MAX_VALUE, rem = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                answer += alphabet(name.charAt(i));

                if (i == 0) continue;
                int tmp = rem + name.length() - i;
                cnt = Math.min(cnt, Math.min(tmp + rem, tmp + name.length() - i));
                rem = i;
            }
        }
        cnt = Math.min(rem, cnt);
        return answer+cnt;
    }
    public int alphabet(char alphabet) {
        return Math.min(91-(int)alphabet,(int)alphabet - 65);
    }

    public static void main(String[] args) {
        Joystick joystick = new Joystick();
        System.out.println(joystick.solution("ZZZAAAAAAZ"));
    }
}
