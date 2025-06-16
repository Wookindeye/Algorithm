package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b24416 {
    static int f1 = 0;
    static int f2 = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fib(n);
        System.out.println(f1);
        arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        fibonacci(n);
        System.out.println(f2);

    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            f1 ++;
            return 1;
        } else{
            return fib(n - 1) + fib(n - 2);
        }
    }

    static int fibonacci(int n) {
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            f2++;
        }
        return arr[n];
    }
}
