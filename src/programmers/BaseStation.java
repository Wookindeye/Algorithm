package programmers;

public class BaseStation {
    public int solution(int n, int[] stations, int w) {
        int idx = 0;
        int apt = 1;
        int cnt = 0;
        while (apt <= n) {
            if(idx < stations.length && apt >= stations[idx] - w){
                apt = stations[idx] + w + 1;
                idx++;
            }else{
                apt += w * 2+1;
                cnt++;
            }
        }
        return cnt;
    }
}
