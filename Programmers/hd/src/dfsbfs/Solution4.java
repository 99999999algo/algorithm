package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution4 {

    public static boolean[] visited;
    public static List<String> candidates = new ArrayList<>();
    private final static String SOURCE = "ICN";

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, SOURCE, SOURCE, tickets);
        Collections.sort(candidates);
        String[] answer = candidates.get(0).split(" ");
        return answer;
    }

    public static void dfs(int count, String present, String answer, String[][] tickets) {
        if (count == tickets.length) {
            candidates.add(answer);
            return;
        }

        for (int i=0; i<tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(present)) {
                visited[i] = true;
                dfs(count+1, tickets[i][1], answer+ " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };
        Arrays.stream(solution(tickets)).forEach(System.out::println);
    }
}
