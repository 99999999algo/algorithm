package search;

import java.util.Arrays;

/**
 * 2022.03.29.
 * 프로그래머스 고득점 kit - 완전탐색 - 카펫
 * https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
 */
public class Solution3 {

    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int sum = brown + red;
        for (int i=sum-1;i>2;i--) {
            if (sum % i == 0 && sum/i > 2) {
                int a = i;
                int b = sum/i;
                if ((a-2)*(b-2)==red) {
                    answer[0] = a;
                    answer[1] = b;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int brown = 10;
        int red = 2;
        Arrays.stream(solution(brown, red)).forEach(System.out::println);
    }
}
