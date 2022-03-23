package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2022.03.22.
 * 프로그래머스 고득점 kit - 해시 - 전화번호 목록
 * https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
 */
public class Solution2 {

    public static boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        for (int i=0; i<phone_book.length; i++)
            for (int j=0; j<phone_book[i].length(); j++)
                if (set.contains(phone_book[i].substring(0, j)))
                    return false;
        return true;
    }

    // 실행 확인
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }
}
