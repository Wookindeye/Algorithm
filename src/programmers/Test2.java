package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Test2 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[col-1] == o2[col-1]) {
                    return Integer.compare(o2[0],o1[0]);
                }
                return Integer.compare(o1[col-1], o2[col-1]);
            }
        });
        int[] mods = new int[row_end - row_begin + 1];
        int idx = 0;
        for (int i = row_begin-1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j] % (i+1);
            }
            mods[idx] = sum;
            idx++;
        }
        answer = mods[0];
        for (int i = 1; i < mods.length; i++) {
            answer = answer ^ mods[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        Test2 test2 = new Test2();
        System.out.println(test2.solution(data,2,2,3));
    }
}
