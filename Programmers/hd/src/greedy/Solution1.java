package greedy;

/**
 * 2022.03.30.
 * 프로그래머스 고득점 kit - 탐욕법 - 체육복
 * https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
 */
public class Solution1 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] std = new int[n];
        for (int i=0;i<n;i++){
            std[i] = 1;
        }

        for(int i : reserve){
            std[i-1]++;
        }
        for(int i : lost){
            std[i-1]--;
        }
        int count = n;
        for (int i=0;i<n;i++){
            if (std[i]==0) {
                if (i==0){
                    if(std[1]!=2){count--;}
                    else if(std[1]==2){std[1]--;}
                } else if(i==n-1){
                    if(std[n-2]!=2){count--;}
                } else {
                    if (std[i-1]==2){
                        std[i-1]--;
                    } else if (std[i+1]==2){
                        std[i+1]--;
                    }else {
                        count--;
                    }
                }
            }
        }
        answer = count;
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(n, lost, reserve));
    }
}
