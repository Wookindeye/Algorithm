package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int avg= 0;
        int mid, mod = 0, gap;
        int maxCount = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            nums[i] = input;
            avg += input;
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else map.put(input, 1);
            if(map.get(input) > maxCount) maxCount = map.get(input);
        }
        avg = (int) Math.round((double) avg / n);
        int[] sorted = Arrays.copyOf(nums, n);

        if(sorted.length > 1){
            Arrays.sort(sorted);
            mid = sorted[n / 2];
        } else mid = sorted[0];

        gap = Math.abs(sorted[n-1] - sorted[0]);

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) == maxCount && !arr.contains(nums[i])) {
                arr.add(nums[i]);
            }
        }
        arr.sort(Comparator.naturalOrder());
        if(arr.size() > 1) {
            mod = arr.get(1);
        }else{
            mod = arr.get(0);
        }
        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mod);
        System.out.println(gap);
    }
}
