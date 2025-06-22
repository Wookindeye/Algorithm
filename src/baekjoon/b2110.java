package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class b2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] wifi = new int[n];

        for (int i = 0; i < n; i++) {
            wifi[i] = sc.nextInt();
        }
        Arrays.sort(wifi);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int tmp = wifi[i + 1] - wifi[i];
            if(tmp < min) min = tmp;
        }
        int s = 1, e = wifi[n-1] - wifi[0];
        int answer = min;
        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 1;
            int lastInstalled = wifi[0];

            for (int i = 1; i < n; i++) {
                if (wifi[i] - lastInstalled >= mid) {
                    cnt++;
                    lastInstalled = wifi[i];
                }
            }

            if (cnt >= c) {
                answer = mid;  // 가능한 거리 → 최대화 시도
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
