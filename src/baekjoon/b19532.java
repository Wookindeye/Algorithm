package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b19532 {
    public static void main(String[] args) throws IOException {
        String answer = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] nums = new int[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if (nums[0] * i + nums[1] * j == nums[2] && nums[3] * i + nums[4] * j == nums[5]) {
                    answer = i + " " + j;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
