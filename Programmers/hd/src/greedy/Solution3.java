package greedy;

/**
 * 2022.03.30.
 * 프로그래머스 고득점 kit - 탐욕법 - 큰 수 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/42883?language=java
 */
public class Solution3 {

    public static String solution(String number, int k) {
        int idx = 0;
        char max;
        StringBuilder answer = new StringBuilder();

        if(number.charAt(0) == '0') return "0";

        for(int i = 0; i < number.length() - k; i++) {
            max = '0';
            for(int j = idx; j <= k + i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j); idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        System.out.println(solution(number, k));
    }
}
