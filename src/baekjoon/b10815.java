package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class b10815 {
    public static void main(String [] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nSize = Integer.parseInt(br.readLine());
        int[] N = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i : N) {
            set.add(i);
        }
        int mSize = Integer.parseInt(br.readLine());
        String[] sArray = br.readLine().split((" "));
        for (String s : sArray) {
            if(set.contains(Integer.parseInt(s))){
                System.out.print(1);
            }else System.out.print(0);
            System.out.print(" ");
        }
    }
}
