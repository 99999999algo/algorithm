package stackqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 2022.03.23.
 * 프로그래머스 고득점 kit - 스택/큐 - 주식가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
 */
public class Solution4 {

    // 스택 활용
    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack();

        for (int i=0; i<prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 떨어진 주식 시간 계산
                answer[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        // 떨어지지 않은 주식들
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }

    // 무지성 비교
    public static int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j<prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        
        return answer;
    }

    // 실행 확인
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        Arrays.stream(solution(prices)).forEach(System.out::println);
    }
}
