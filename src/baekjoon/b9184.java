package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b9184 {
    static int[][][] arr = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            int c = input[2];

            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a,b,c));
        }
    }

    static int w(int a, int b, int c) {
        if( a <= 0 || b <= 0 || c<= 0) return 1;
        if( a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        if( a < b && b < c){
            int i1, i2, i3;
            if(arr[a][b][c-1] != 0) i1 = arr[a][b][c-1];
            else {
                i1 = w(a, b, c - 1);
                arr[a][b][c-1] = i1;
            }

            if(arr[a][b-1][c-1] != 0) i2 = arr[a][b-1][c-1];
            else {
                i2 = w(a, b-1, c - 1);
                arr[a][b - 1][c - 1] = i2;
            }

            if(arr[a][b-1][c] != 0) i3 = arr[a][b-1][c];
            else {
                i3 = w(a, b-1, c);
                arr[a][b - 1][c] = i3;
            }

            return i1 + i2 - i3;
        }
        int i1, i2, i3, i4;
        if(arr[a-1][b][c] != 0) i1 = arr[a-1][b][c];
        else {
            i1 = w(a - 1, b, c);
            arr[a-1][b][c] = i1;
        }
        if(arr[a-1][b-1][c] != 0) i2 = arr[a-1][b-1][c];
        else {
            i2 = w(a - 1, b-1, c);
            arr[a-1][b-1][c] = i2;
        }
        if(arr[a-1][b][c-1] != 0) i3 = arr[a-1][b][c-1];
        else {
            i3 = w(a - 1, b, c - 1);
            arr[a-1][b][c-1] = i3;
        }
        if(arr[a-1][b-1][c-1] != 0) i4 = arr[a-1][b-1][c-1];
        else {
            i4 = w(a - 1, b - 1, c -1);
            arr[a-1][b-1][c-1] = i4;
        }
        return i1 + i2 + i3 - i4;
    }

}
