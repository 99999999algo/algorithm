package dfsbfs;

public class Solution2 {

    public static boolean[] check;

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        check = new boolean[n];
        for (int i=0; i<n; i++) {
            if (!check[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    public static void bfs(int index, int[][] computers) {
        if (check[index])
            return;

        check[index] = true;

        for (int i=0; i< computers.length; i++) {
            if (index != i && computers[index][i] == 1) {
                if (!check[i]) {
                    bfs(i, computers);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solution(n, computers));

    }
}
