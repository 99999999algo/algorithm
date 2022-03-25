package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2022.03.25.
 * 프로그래머스 고득점 kit - 정렬 - 가장 큰 수
 * https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
 */
public class Solution2 {

    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] numberToStr = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            numberToStr[i] = String.valueOf(numbers[i]);
        }

        // 내림차순 정렬
        Arrays.sort(numberToStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if (numberToStr[0].equals("0")) return "0";

        for (String s: numberToStr) {
            answer.append(s);
        }
        return answer.toString();
    }

    // 실행 확인
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
}
