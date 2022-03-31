package greedy;

import java.util.PriorityQueue;

/**
 * 2022.03.30.
 * 프로그래머스 고득점 kit - 탐욕법 - 섬 연결하기
 * https://programmers.co.kr/learn/courses/30/lessons/42861?language=java
 */
public class Solution5 {

    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        pq = new PriorityQueue<Edge>();

        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int i = 0; i < costs.length; i++) {
            pq.offer(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.start) == find(edge.end)) continue;
            else {
                union(edge.start, edge.end);
                answer += edge.cost;
            }
        }

        return answer;
    }

    public static int find(int p) {
        if (parent[p] == p) return p;
        return parent[p] = find(parent[p]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) parent[rootB] = rootA;
    }


    static class Edge implements Comparable<Edge> {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n, costs));
    }
}
