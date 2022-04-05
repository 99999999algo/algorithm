package dfsbfs;

public class Solution1 {

    public static int answer = 0;

    public static int solution(int[] numbers, int target) {
        int length = numbers.length;
        dfs(0, length, 0, numbers, target);
        return answer;
    }

    public static void dfs(int count, int length, int result, int[] numbers, int target) {
        if (count == length) {
            if (result == target)
                answer++;
            return;
        }

        int n = numbers[count];
        count++;

        dfs(count, length, result + n, numbers, target);
        dfs(count, length, result - n, numbers, target);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
