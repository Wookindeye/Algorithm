package baekjoon;
import java.util.Scanner;

public class b11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        for(int i = n; i > 0; i-- ){
            coins[i - 1] = sc.nextInt();
        }
        int cnt = 0;
        int index = 0;
        while (k != 0) {
            if (k / coins[index] > 0) {
                cnt += k / coins[index];
                k %= coins[index];
            } else{
                index ++;
            }
        }
        System.out.println(cnt);

    }
}
