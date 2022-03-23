package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2022.03.23.
 * 프로그래머스 고득점 kit - 스택/큐 - 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583?language=java
 */
public class Solution3 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;
        int currentWeightOfBridge = 0;
        Queue<Integer> currentBridge = new LinkedList<>();
        for (int i=0; i<bridge_length; i++)
            currentBridge.add(0);

        int index = 0;
        while(index < truck_weights.length) {
            time++;
            currentWeightOfBridge -= currentBridge.poll();

            int truckWeight = truck_weights[index];

            if (currentWeightOfBridge + truckWeight <= weight) {
                // 트럭이 다리에 올라갈 수 있는 경우
                currentBridge.add(truckWeight);
                currentWeightOfBridge += truckWeight;
                index++;
            } else {
                // 트럭이 다리에 올라갈 수 없는 경우
                currentBridge.add(0);
            }
        }

        // 마지막 트럭이 다리에서 나가는 시간 추가
        while (!currentBridge.isEmpty()) {
            currentBridge.poll();
            time++;
        }

        return time;
    }

    // 실행 확인
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
