package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2022.03.23.
 * 프로그래머스 고득점 kit - 스택/큐 - 프린터
 * https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
 */
public class Solution2 {

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Job> queue = new LinkedList<>();

        for (int i=0; i<priorities.length; i++)
            queue.add(new Job(i, priorities[i]));

        int index = 0;
        while (!queue.isEmpty()) {
            Job currentJob = queue.poll();

            // 우선순위가 높은 작업 있는지 확인
            boolean isUpperPriority = false;
            for (Job q: queue) {
                if (q.priority > currentJob.priority) {
                    isUpperPriority = true;
                    break;
                }
            }

            // 우선순위가 높은 작업이 있는 경우 뒤로 추가
            if (isUpperPriority)
                queue.add(currentJob);
            // 우선순위가 높은 작업이 없는 경우 location 비교해서 같으면 return
            else {
                index++;
                if (currentJob.location == location) {
                    answer = index;
                    break;
                }
            }
        }
        return answer;
    }

    public static class Job {
        int location;
        int priority;

        public Job(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    // 실행 확인
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }
}
