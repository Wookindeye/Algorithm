package programmers;

import java.util.Arrays;

public class Lcm {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) { //내림차순 정렬
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - 1 - i] = tmp;
        }
        int[] mult = new int[arr.length];
        Arrays.fill(mult,0);
        int index = 0, lcm = 0;
        while (index < arr.length) {
            if (index == 0) {
                mult[index]++;
                lcm = arr[index] * mult[index];
                index++;
                continue;
            }
            int tmp = arr[index];
            while (tmp < lcm) {
                mult[index]++;
                tmp = arr[index] * mult[index];
            }
            if(tmp== lcm) index++;
            else index = 0;
        }
        return lcm;
    }

    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        Lcm lcm = new Lcm();
        System.out.println(lcm.solution(arr));
    }
}
