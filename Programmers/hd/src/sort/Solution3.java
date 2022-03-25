package sort;

import java.util.Arrays;

/**
 * 2022.03.25.
 * 프로그래머스 고득점 kit - 정렬 - H-Index
 * https://programmers.co.kr/learn/courses/30/lessons/42747?language=java
 */
public class Solution3 {

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i=0; i<citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                answer = citations.length - i;
                break;
            }
        }
        return answer;
    }

    // 실행 확인
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }
}
