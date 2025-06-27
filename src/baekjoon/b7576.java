package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b7576 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] tomato = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = sc.nextInt();
                tomato[i][j] = tmp;
                if(tmp == 1){
                    q.offer(new int[]{i,j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny >= 0 && ny < n && nx >= 0 && nx < m){
                    if(tomato[ny][nx] == 0){
                        tomato[ny][nx] = tomato[cy][cx] + 1;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            boolean stop = false;
            for (int j = 0; j < m; j++) {
                if(tomato[i][j] == 0){
                    max = -1;
                    stop = true;
                    break;
                }else if(tomato[i][j] > 1 && tomato[i][j] > max) max = tomato[i][j];
            }
            if(stop) break;
        }
        if(max != 0 && max != -1) System.out.println(max - 1);
        else System.out.println(max);
    }
}
