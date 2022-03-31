package search;

import java.util.ArrayList;

/**
 * 2022.03.29.
 * 프로그래머스 고득점 kit - 완전탐색 - 소수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
 */
public class Solution2 {

    static ArrayList<Integer> nums = new ArrayList<>();

    public static int solution(String numbers) {
        int answer = 0;

        int len = numbers.length();
        String[] strNums = numbers.split("");

        for (int r=1; r<=len; r++) {
            // 카드 조합 후 숫자로
            permutation(strNums, 0, len, r);
        }

        // 소수 판별
        for (Integer num: nums) {
            boolean isPrime = true;
            if (num < 2) {
                isPrime = false;
            }
            for (int i=2; i<num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                answer++;
            }
        }

        return answer;
    }

    static void permutation(String[] arr, int depth, int n, int r) {
        if (depth == r) {
            add(arr, r);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void add(String[] arr, int n) {
        String s = "";
        for (int i=0;i<n;i++) {
            s += arr[i];
        }
        int num = Integer.valueOf(s);

        if (nums.contains(num)) {
            return;
        } else {
            nums.add(num);
        }
    }

    public static void main(String[] args) {
        String answers = "011";
        System.out.println(solution(answers));
    }
}
