package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] nums = new int[2];
        for (int i = 0; i < 2; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int a = nums[0];
        int b = nums[1];
        int answer = 64;
        char[][] board = new char[a][b];
        for (int i = 0; i < a; i++) {
            String s2 = br.readLine();
            for (int j = 0; j < b; j++) {
                board[i][j] = s2.charAt(j);
            }
        }
        for (int i = 0; i < a-7; i++){
            for (int j = 0; j < b-7; j++) {
                int cnt1 = 0;
                boolean color = board[i][j] == 'B';
                boolean color2 = !color;
                for (int y = i; y < i + 8; y++) {
                    boolean colorTmp = board[y][j]=='B';
                    if (color != colorTmp) {
                        cnt1++;
                    }
                    else colorTmp = !colorTmp;
                    for (int x = j+1; x < j+8; x++) {
                        boolean colorTmp2 = board[y][x] == 'B';
                        if (colorTmp2 != colorTmp) {
                            cnt1++;
                        }
                        colorTmp = !colorTmp;
                    }
                    color = !color;
                }
                //맨쪽 맨 위칸의 색깔을 변경했을 때 경우의 수가 더 작게 나올 수 있다.
                int cnt2 = 0;
                for (int y = i; y < i + 8; y++) {//먼저 왼쪽 맨 위칸을 확인.
                    boolean colorTmp = board[y][j]=='B';
                    if (color2 != colorTmp) {//현재 블럭이 새로 칠해야 하는 경우
                        cnt2++;
                    }
                    else colorTmp = !colorTmp;
                    for (int x = j+1; x < j+8; x++) {
                        boolean colorTmp2 = board[y][x] == 'B';
                        if (colorTmp2 != colorTmp) {
                            cnt2++;
                        }
                        colorTmp = !colorTmp;
                    }
                    color2 = !color2;// 다음줄 맨 앞 블록은 현재 블록의 색깔과 반대여야 함을 정해놓음.
                }
                answer = Math.min(answer, Math.min(cnt1,cnt2));
            }
        }
        System.out.println(answer);
    }
}
