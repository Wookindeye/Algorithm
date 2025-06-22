package baekjoon;
import java.io.IOException;
import java.util.Scanner;

public class b1012 {
    static boolean[][] farm;
    static int m, n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            int cnt = 0;
            farm = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                farm[y][x] = true;
            }
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if(farm[y][x]) {
                        bfs(y, x);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int y, int x) {
        farm[y][x] = false;
        if(x < m - 1 && farm[y][x + 1]) bfs(y, x + 1);
        if(y < n - 1 && farm[y + 1][x]) bfs(y + 1, x);
        if (y > 0 && farm[y - 1][x]) bfs(y - 1, x);
        if (x > 0 && farm[y][x - 1]) bfs(y, x - 1);
    }
}
