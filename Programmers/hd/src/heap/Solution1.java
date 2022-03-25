package heap;

import java.util.PriorityQueue;

/**
 * 2022.03.25.
 * 프로그래머스 고득점 kit - 힙 - 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
 */
public class Solution1 {

    public static int solution(int[] scoville, int K) {
        int answer = 0, value = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 모든 스코빌 지수 우선순위큐에 추가
        for (int s: scoville) {
            pq.add(s);
        }

        // 스코빌 지수가 가장 낮은 값이 K 이상일 때까지 반복
        while (pq.peek() < K) {
            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
            if (pq.size() < 2)
                return -1;

            value = pq.poll() + pq.poll() * 2;
            pq.add(value);
            answer++;
        }

        return answer;
    }

    // 실행 확인
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
}
