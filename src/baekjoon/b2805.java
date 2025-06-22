package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        long m = nm[1];

        long[] tree = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(tree);
        long s = 0;
        long e = tree[tree.length-1];
        long answer = 0;
        while (s <= e) {
            long mid = (s+e)/2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (tree[i] - mid > 0) {
                    sum += tree[i] - mid;
                }
            }
            if(sum >= m){
                answer = mid;
                s = mid + 1;
            }
            else e = mid - 1;
        }
        System.out.println(answer);
    }
}
