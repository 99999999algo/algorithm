package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2022.03.31.
 * 프로그래머스 고득점 kit - 탐욕법 - 단속카메라
 * https://programmers.co.kr/learn/courses/30/lessons/42884?language=java
 */
public class Solution6 {

    public static int solution(int[][] routes) {
        int answer = 0;
        int station = Integer.MIN_VALUE;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] route1, int[] route2) {
                return route1[1] - route2[1];
            }
        });

        for(int[] route : routes) {
            if(station < route[0]) {
                station = route[1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};
        System.out.println(solution(routes));
    }
}
