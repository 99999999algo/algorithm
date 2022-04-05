package dp;

import java.util.Arrays;

public class Solution2 {

    public static int[][] max;
    public static int candidate1 = 0, candidate2 = 0;

    public static int solution(int[][] triangle) {
        int length = triangle.length;
        max = new int[length][length];

        for (int i=0; i<length; i++) {
            for (int j=0; j<=i; j++) {
                if (i == 0) {
                    max[i][j] = triangle[i][j];
                } else {
                    if (j-1 >= 0) candidate1 = triangle[i][j] + max[i-1][j-1];
                    else candidate1 = 0;
                    if (j < i) candidate2 = triangle[i][j] + max[i-1][j];
                    else candidate2 = 0;
                    max[i][j] = Math.max(candidate1, candidate2);
                }
            }
        }

        Arrays.sort(max[length-1]);
        return max[length-1][length-1];
    }

    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        System.out.println(solution(triangle));
    }
}
