package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class b1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] lan = new int[k];
        for (int i = 0; i < k; i++) {
            lan[i] = sc.nextInt();
        }
        Arrays.sort(lan);
        long answer = 0;
        long s = 1, e = lan[k - 1];
        while (s <= e) {
            long mid = (s + e) / 2;
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += lan[i] / mid;
            }
            if(sum >= n){
                answer = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
