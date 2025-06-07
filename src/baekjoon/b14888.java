package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b14888 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        recursive(ops,1,nums[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static int calculate(int a, int b, int op){
        if(op == 0) return a + b;
        else if(op == 1) return a - b;
        else if(op == 2) return a * b;
        else{
            if(a < 0 && b > 0){
                a = a * -1;
                int tmp = a / b;
                return tmp * -1;
            }
            else return a / b;
        }
    }

    static void recursive(int[] ops, int depth, int cal) {
        if(depth == nums.length){
            if(cal > max) max = cal;
            if(cal < min) min = cal;
            return;
        }
        for (int i = 0; i < ops.length; i++) {
            if (ops[i] > 0){
                int tmp = calculate(cal, nums[depth], i);
                ops[i]--;
                recursive(ops, depth + 1, tmp);
                ops[i]++;
            }
        }
    }
}
