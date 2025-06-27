package baekjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b2178 {
    static int[][] map;
    static boolean[][] visited;
    static int n,m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(map[n - 1][m - 1]);
    }
    static void bfs( int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int cy = c[0];
            int cx = c[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (!visited[ny][nx] && map[ny][nx] != 0) {
                        visited[ny][nx] = true;
                        map[ny][nx] = map[cy][cx] + 1;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
