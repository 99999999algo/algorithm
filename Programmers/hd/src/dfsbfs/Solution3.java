package dfsbfs;

public class Solution3 {

    public static boolean[] check;
    public static int answer = 0;

    public static int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (check[i]) { continue; }

            int k = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) { k++; }
            }

            if (k == begin.length() - 1) {
                check[i] = true;
                dfs(words[i], target, words, count + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        System.out.println(solution(begin, target, words));
    }
}
