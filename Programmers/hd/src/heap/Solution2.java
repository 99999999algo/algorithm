package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2022.03.25.
 * 프로그래머스 고득점 kit - 힙 - 디스크 컨트롤러
 * https://programmers.co.kr/learn/courses/30/lessons/42627?language=java
 */
public class Solution2 {

    public static int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int index = 0;
        int time = 0;
        int length = jobs.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 작업 시작 순서에 따라 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        while (count < length) {
            while (index < length && jobs[index][0] <= time) {
                pq.add(jobs[index++]);
            }

            if (pq.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] temp = pq.poll();
                answer += temp[1] + time - temp[0];
                time += temp[1];
                count++;
            }
        }

        return (int) Math.floor(answer / length);
    }

    // 실행 확인
    public static void main(String[] args) {
        int[][] jobs = {
                {0, 3},
                {1, 9},
                {2, 6}
        };
        System.out.println(solution(jobs));
    }
}
