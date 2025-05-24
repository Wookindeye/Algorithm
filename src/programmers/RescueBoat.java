package programmers;

import java.util.Arrays;

public class RescueBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] > limit) {
                heavy--;
                answer++;
            }
            else{
                answer++;
                heavy--; light ++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] i = {70, 50, 40, 50, 50,40,40};
        RescueBoat sb = new RescueBoat();
        System.out.println(sb.solution(i,100));
    }
}
