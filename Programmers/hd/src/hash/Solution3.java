package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2022.03.22.
 * 프로그래머스 고득점 kit - 해시 - 위장
 * https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
 */
public class Solution3 {

    public static List<String> list;

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();

        for (String[] cloth: clothes) {
            list = map.getOrDefault(cloth[1], new ArrayList<>());
            list.add(cloth[0]);
            map.put(cloth[1], map.getOrDefault(cloth[1], list));
        }

        for (String key: map.keySet()) {
            answer *= (map.get(key).size() + 1);
        }

        return answer - 1;
    }

    // 실행 확인
    public static void main(String[] args) {
        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solution(clothes));
    }
}
