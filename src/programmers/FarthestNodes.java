package programmers;

import java.util.*;

public class FarthestNodes {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] shortest = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < edge.length; i++){
            list.get(edge[i][0]).add(edge[i][1]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        for(int des : list.get(1)){
            q.offer(des);
            distance[des] = 1;
            visited[des] = true;
        }
        int max = 0;
        while(!q.isEmpty()){
            int des = q.poll();
            for(int i : list.get(des)){
                q.offer(i);
                visited[i] = true;
                distance[i] = distance[des] + 1;
                if(distance[i] > max)
                    max = distance[i];
            }
        }
        for(int i = 0; i < n; i++){
            if(distance[i] == max){
                answer++;
            }
        }
        return answer;
    }
}
