package stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2022.03.23.
 * 프로그래머스 고득점 kit - 스택/큐 - 기능개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
 */
public class Solution1 {

    private static final int MAX_PROGRESS = 100;

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int length = progresses.length;
        int remain = 0; // 오래 걸리는 작업 id
        int count = 0; // 작업 카운팅
        int value = 0; // 작업 일수

        for (int i=0; i<length; i++) {
            value = (MAX_PROGRESS - progresses[i]) / speeds[i] + 1;
            // 나누어 떨어지는 경우 1 빼기
            value -= ((MAX_PROGRESS - progresses[i]) % speeds[i]) == 0 ? 1 : 0;

            if (i==0)
                remain = value;
            
            if (remain >= value) {
                // 이전 작업보다 오래 걸리지 않는 경우 카운팅
                count++;
            } else {
                // 이전 작업보다 오래 걸리는 경우 누적된 카운팅 리스트에 추가
                list.add(count);
                remain = value;
                count = 1;
            }
        }
        // 마지막에 남은 카운팅 리스트에 추가
        list.add(count);

        // List to Array
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }

    // 실행 확인
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        Arrays.stream(solution(progresses, speeds)).forEach(System.out::println);
    }
}
