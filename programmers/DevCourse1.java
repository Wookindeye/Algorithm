package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class DevCourse1 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,5,5,5,4,4,4,6,6,6,8,8,4,4,4,4,3,3,3,3,3,4};
        System.out.println(Arrays.toString(solution(nums)));
    }
    public static int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int tmp = arr[0];
        list.add(tmp);
        for(int i=1; i<arr.length; i++) {
            if (arr[i] != tmp) {
                list.add(arr[i]);
                tmp = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
