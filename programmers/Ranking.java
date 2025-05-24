package programmers;

import java.util.*;

public class Ranking {
    Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (String s : info) {
            String[] strings = s.split(" ");
            combinations(strings,"", 0);
        }
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        for (int i = 0; i < query.length; i++) {
            String s = query[i].replace(" and ", "").split(" ")[0];
            int scr = Integer.parseInt(query[i].split(" ")[7]);
            answer[i] = matching(s, scr);
        }
        return answer;
    }
    public void combinations(String[] s, String str, int cnt) {
        if(cnt == 4) {
            if (!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
            map.get(str).add(Integer.parseInt(s[4]));
        }
        else {
            combinations(s, str + "-", cnt+1);
            combinations(s, str + s[cnt], cnt+1);
        }
    }
    public int matching(String s, int goal) {
        if(!map.containsKey(s)) return 0;
        List<Integer> list = map.get(s);
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) /2;
            if (goal > list.get(mid)) left = mid+1;
            else right = mid -1;
        }
        return list.size() - left;
    }
}
