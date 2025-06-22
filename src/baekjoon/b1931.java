package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class b1931 {
    /*
        - 정렬
        1. 회의 종료 시간이 가장 이른 순으로 정렬
        2. 같을 경우 시작시간이 이른 순으로 정렬
        - 반복문
        1. 첫번째 회의 종료시간을 저장.
        2. 다음 회의들의 시작시간이 이전 회의 종료시간과 같거나 클 경우 저장.

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        list.sort((a1,a2) -> {
            if (a1[1] == a2[1]) return Integer.compare(a1[0], a2[0]);
            else return Integer.compare(a1[1], a2[1]);
        });

        int cnt = 0;
        int lastMeet = -1;
        for (int[] meet : list) {
            if(meet[0] >= lastMeet){
                cnt++;
                lastMeet = meet[1];
            }
        }
        System.out.println(cnt);
    }
}
