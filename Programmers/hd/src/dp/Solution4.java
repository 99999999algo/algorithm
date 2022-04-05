package dp;

public class Solution4 {

    public static int solution(int[] money) {
        int length = money.length;
        int[] candidate1 = new int[length];
        int[] candidate2 = new int[length];

        // candidate1 : 첫 번째 집을 터는 경우(마지막 집 포기)
        candidate1[0] = money[0];
        candidate1[1] = Math.max(money[0], money[1]);

        // candidate2 : 첫 번째 집을 안 터는 경우
        candidate2[0] = 0;
        candidate2[1] = money[1];

        for (int i=2; i<length; i++) {
            if (i == length-1)
                candidate1[i] = Math.max(candidate1[i-1], candidate1[i-2]);
            else
                candidate1[i] = Math.max(candidate1[i-1], candidate1[i-2] + money[i]);

            candidate2[i] = Math.max(candidate2[i-1], candidate2[i-2] + money[i]);
        }

        return Math.max(candidate1[length-1], candidate2[length-1]);
    }

    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        System.out.println(solution(money));
    }
}
