package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2022.03.25.
 * 프로그래머스 고득점 kit - 힙 - 디스크 컨트롤러
 * https://programmers.co.kr/learn/courses/30/lessons/42627?language=java
 */
public class Solution3 {

    public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minpq = new PriorityQueue<>();

        for (String operation: operations) {
            String[] split = operation.split(" ");

            if (split[0].equals("I")) {
                int number = Integer.parseInt(split[1]);
                maxpq.add(number);
                minpq.add(number);
            } else {
                if (!maxpq.isEmpty()) {
                    // 큐에 남아있을 때만 삭제
                    if (split[1].equals("1")) minpq.remove(maxpq.poll()); // 최댓값 제거
                    else maxpq.remove(minpq.poll()); // 최솟값 제거
                }
            }
        }

        if (maxpq.size() != 0) {
            answer[0] = maxpq.peek();
            answer[1] = minpq.peek();
        }

        return answer;
    }

    // 실행 확인
    public static void main(String[] args) {
        String[] operations = {"I 7","I 5","I -5","D -1"};
        Arrays.stream(solution(operations)).forEach(System.out::println);
    }
}
