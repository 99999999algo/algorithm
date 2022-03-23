package hash;

import java.util.Arrays;

/**
 * 2022.03.22.
 * 프로그래머스 고득점 kit - 해시 - 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 */
public class Solution1 {

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int length = participant.length;
        for (int i=0; i< length; i++) {
            if (i == length-1) return participant[i];
            if (!participant[i].equals(completion[i])) return participant[i];
        }
        return null;
    }

    // 실행 확인
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));
    }
}
