package binary;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/43236?language=java
public class Solution2 {

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        int length = rocks.length;
        Arrays.sort(rocks);

        int left = 0;
        int right = distance;
        int mid;
        int prev, count;

        while (left <= right) {
            mid = (left+right) / 2;
            prev = 0;
            count = 0;

            for (int i=0; i<length; i++) {
                if (rocks[i] - prev < mid) {
                    count++;
                    continue;
                }
                prev = rocks[i];
            }

            if (count <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        System.out.println(solution(distance, rocks, n));
    }
}
