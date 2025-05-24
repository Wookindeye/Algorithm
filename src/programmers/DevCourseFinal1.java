package programmers;

import java.util.HashMap;
import java.util.Map;

public class DevCourseFinal1 {
    public static void main(String[] args) {

    }
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> map = new HashMap<>(Map.of(
            'R', 0, 'T', 0, 'C', 0, 'F', 0, 'J', 0, 'M', 0, 'A', 0,
            'N', 0));
        for(int i = 0; i < survey.length; i++){
            switch(i){
                case 1:
                    map.put(survey[i].charAt(0),map.get(survey[i].charAt(0))+3);
                    break;
                case 2:
                    map.put(survey[i].charAt(0),map.get(survey[i].charAt(0))+2);
                    break;
                case 3:
                    map.put(survey[i].charAt(0),map.get(survey[i].charAt(0))+1);
                    break;
                case 4: break;
                case 5:
                    map.put(survey[i].charAt(1),map.get(survey[i].charAt(1))+1);
                    break;
                case 6:
                    map.put(survey[i].charAt(1),map.get(survey[i].charAt(1))+2);
                    break;
                case 7:
                    map.put(survey[i].charAt(1),map.get(survey[i].charAt(1))+3);
                    break;
            }
            if(map.get('R') >= map.get('T')) sb.append('R');
            else if(map.get('R') <= map.get('T')) sb.append('T');
            else sb.append('R');

        }


        return sb.toString();
    }

}
