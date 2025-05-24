package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoColoringBook {
    int[][] search = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};//순회방향
    long[][] picture;//그림
    boolean [][] visit;//방문확인
    int M,N;//그림의 크기
    public int[] solution(int m, int n, int[][] picture) {
        this.picture = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.picture[i][j] = picture[i][j];
            }
        }
        M = m; N = n;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visit[i][j]) {
                    int size = bfs(i,j,picture[i][j]);
                    numberOfArea++;
                    if (size > maxSizeOfOneArea) maxSizeOfOneArea = size;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static class Point{
        Point(int x, int y){
            this.x = x; this.y = y;
      }
        int x, y;
    }
    public int bfs(int m, int n, int color) {
        Queue<Point> queue = new LinkedList<>();
        visit[m][n]= true;
        queue.add(new Point(n, m));
        int size = 1;
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = tmp.x + search[i][1], y = tmp.y + search[i][0];
                if (x >= N || x < 0 || y >= M || y < 0||visit[y][x]) continue;
                if(picture[y][x] == color){
                    size++;
                    queue.add(new Point(x, y));
                    visit[y][x] = true;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        KakaoColoringBook kakaoColoringBook = new KakaoColoringBook();
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        //int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        System.out.println(Arrays.toString(kakaoColoringBook.solution(6, 4, picture)));
    }
}
