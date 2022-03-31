package greedy;

/**
 * 2022.03.30.
 * 프로그래머스 고득점 kit - 탐욕법 - 조이스틱
 * https://programmers.co.kr/learn/courses/30/lessons/42860?language=java
 */
public class Solution2 {
    public static int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min_move = len-1;

        for(int i=0; i<len; i++) {
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

            int next = i+1;
            while(next<len && name.charAt(next) == 'A')
                next++;

            min_move = Math.min(min_move, i+len-next + i);
        }

        answer += min_move;

        return answer;
    }

    public static void main(String[] args) {
        String name = "JEROEN";
        System.out.println(solution(name));
    }
}
