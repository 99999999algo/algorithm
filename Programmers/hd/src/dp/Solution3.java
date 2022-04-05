package dp;

public class Solution3 {

    public static int[][] map;

    public static int solution(int m, int n, int[][] puddles) {
        map = new int[n][m];

        // 물에 잠긴 지역 설정
        for (int[] puddle: puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }

        // 경로 계산
        map[0][0] = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] != -1) {
                    // 오른쪽
                    if (j-1 >= 0 && map[i][j-1] != -1)
                        map[i][j] += map[i][j-1];
                    // 아래
                    if (i-1 >= 0 && map[i-1][j] != -1)
                        map[i][j] += map[i-1][j];
                    map[i][j] %= 1000000007;
                }
            }
        }
        return map[n-1][m-1];
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        System.out.println(solution(m,n,puddles));
    }
}
