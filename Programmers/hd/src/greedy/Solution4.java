package greedy;

import java.util.Arrays;

/**
 * 2022.03.30.
 * 프로그래머스 고득점 kit - 탐욕법 - 구명보트
 * https://programmers.co.kr/learn/courses/30/lessons/42885?language=java
 */
public class Solution4 {

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (left == right) {
                answer++;
                left++;
            } else {
                if (people[left]+people[right] <= limit) {
                    left++;
                    right--;
                    answer++;
                } else {
                    right--;
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
}
