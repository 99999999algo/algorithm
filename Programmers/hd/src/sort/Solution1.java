package sort;

import java.util.Arrays;

/**
 * 2022.03.25.
 * 프로그래머스 고득점 kit - 정렬 - K번째수
 * https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
 */
public class Solution1 {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i,j,k,length;
        int[] temp;
        for (int index=0; index<commands.length; index++) {
            i = commands[index][0]-1;
            j = commands[index][1]-1;
            k = commands[index][2]-1;

            length = j-i+1;
            temp = new int[length];
            for (int x=0; x<length; x++) temp[x] = array[x+i];
            Arrays.sort(temp);
            answer[index] = temp[k];
        }
        return answer;
    }

    // 실행 확인
    public static void main(String[] args) {
        int[] array  = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        Arrays.stream(solution(array, commands)).forEach(System.out::println);
    }
}
