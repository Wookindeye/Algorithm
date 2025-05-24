package programmers;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumbers {
    Set<Integer> set = new HashSet<>();
    String numbers;
    public int solution(String numbers) {
        this.numbers = numbers;
        for (int i = 1; i <= numbers.length(); i++) {
            permunation(i, new boolean[numbers.length()], "");
        }
        return set.size();
    }
    public boolean isPrime(int n) {
        if(n<=1) return false;
        if (n <= 3) return true;
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public void permunation(int length, boolean[] visit, String current){
        if(current.length() == length){
            if(isPrime(Integer.parseInt(current))) set.add(Integer.parseInt(current));
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                permunation(length,visit,current+numbers.charAt(i));
                visit[i] = false;
            }
        }
    }
}
