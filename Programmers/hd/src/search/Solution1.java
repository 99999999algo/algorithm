package search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2022.03.29.
 * 프로그래머스 고득점 kit - 완전탐색 - 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
 */
public class Solution1 {

    public static int[] solution(int[] answers) {
        int[] supo = new int[3];
        int i=0, j=0, k=0;
        for (i=0;i<answers.length;i++) {
            int x = answers[i];
            // 1번 채점
            if (i%5==0 && x==1) {supo[0]++;}
            else if (i%5==1 && x==2) {supo[0]++;}
            else if (i%5==2 && x==3) {supo[0]++;}
            else if (i%5==3 && x==4) {supo[0]++;}
            else if (i%5==4 && x==5) {supo[0]++;}
            // 2번
            if (j%2==0) {if (x==2) supo[1]++;}
            else {
                if (j%8==1 && x==1) {supo[1]++;}
                else if (j%8==3 && x==3) {supo[1]++;}
                else if (j%8==5 && x==4) {supo[1]++;}
                else if (j%8==7 && x==5) {supo[1]++;}
            }
            // 3번
            if (k%10<2) {if (x==3) supo[2]++;}
            else if (k%10<4) {if (x==1) supo[2]++;}
            else if (k%10<6) {if (x==2) supo[2]++;}
            else if (k%10<8) {if (x==4) supo[2]++;}
            else if (k%10<10) {if (x==5) supo[2]++;}

            j++;
            k++;
        }

        int[] cmp = new int[3];
        for (i=0;i<3;i++) {
            cmp[i] = supo[i];
        }
        Arrays.sort(supo);
        ArrayList<Integer> al = new ArrayList<>();
        for (i=0;i<3;i++) {
            if (supo[2] == cmp[i])
                al.add(i+1);
        }
        j = al.size();
        int[] answer = new int[j];
        for (i=0;i<j;i++) {
            answer[i] = al.get(0);
            al.remove(0);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        Arrays.stream(solution(answers)).forEach(System.out::println);
    }
}
