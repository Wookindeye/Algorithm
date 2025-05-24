package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Delivery {
    static class Village {
        int n;
        int distance;
        Village(int n, int distance) {
            this.n = n;
            this.distance = distance;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N + 1][N + 1];
        for (int[] ints : road) {
            if (graph[ints[0]][ints[1]] != 0 && graph[ints[0]][ints[1]] < ints[2]) {//두개의 마을사이에 길이 두개이상일 경우 더짧은 길을 선택
                continue;//두 마을 사이에 더 짧은 경로가 이미 존재한다면 스킵
            }
            graph[ints[0]][ints[1]] = graph[ints[1]][ints[0]] = ints[2];
        }
        int[] visit = new int[N+1];//1마을로부터의 최소거리
        Arrays.fill(visit,500001); visit[1] =0;
        Queue<Village> queue = new LinkedList<>();
        queue.add(new Village(1, 0));
        while (!queue.isEmpty()) {
            Village v = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[v.n][i] != 0&& graph[v.n][i] + v.distance < visit[i] ) {
                    visit[i] = graph[v.n][i] + v.distance;
                    queue.add(new Village(i,graph[v.n][i] + v.distance));
                }
            }
        }
        for (int i : visit) {
            if (i <= K) answer++;
        }
        return answer;
    }
}
