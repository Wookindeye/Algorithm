package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    int cnt;
    int[][] computers;
    int n;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n];
        this.computers = computers;
        this.n = n;
        for (int i = 0; i < n; i++) {
            if(computers[i][i] == 1) {
                dfs(i);
                cnt++;
            }
        }

        return cnt;
    }
    public void dfs(int c){
        for (int i = 0; i < n; i++) {
            if(i == c) continue;
            if(computers[c][i] == 1){
                computers[c][i] = 0;
                dfs(i);
            }
        }
        computers[c][c] = 0;
    }
}
