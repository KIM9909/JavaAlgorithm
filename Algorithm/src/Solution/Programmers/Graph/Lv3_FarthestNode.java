package Solution.Programmers.Graph;
// Lv.3 가장 먼 노드

import java.util.*;
public class Lv3_FarthestNode {
    static List<List<Edge>> graph;
    static int totalFarNode = 0;

    // 간선 정보 저장
    static class Edge {
        int targetNode;
        int targetDist;

        Edge (int targetNode, int  targetDist) {
            this.targetNode = targetNode;
            this.targetDist = targetDist;
        }
    }
    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i< edge.length; i++) {
            int A = edge[i][0];
            int B = edge[i][1];

            graph.get(A).add(new Edge(B, 1));
            graph.get(B).add(new Edge(A, 1));
        }

        List<Integer> distances = bfs(1, n);

        // 노드간의 거리를 역정렬해서 가장 먼 거리를 맨앞으로
        distances.sort(Comparator.reverseOrder());
        int farthestD = distances.get(0);

        // 중복되는 값이 있는지 체크
        for (int distance : distances) {
            if (distance == farthestD) {
                totalFarNode ++;
            } else {
                break;
            }
        }

        return totalFarNode;
    }

    static List<Integer> bfs (int start, int n) {
        List<Integer> nodeD = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(new int[] {start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            // 현재 노드와 연결된 모든 노드 탐색
            for (Edge edge : graph.get(currentNode)) {
                int nextNode = edge.targetNode;
                int nextDist = edge.targetDist;

                if (!visited[nextNode]) {
                    int totalDist = currentDist + nextDist;

                    // 인접한 노드의 거리를 저장
                    nodeD.add(totalDist);

                    visited[nextNode] = true;
                    q.offer(new int[] {nextNode, totalDist});
                }
            }
        }

        return nodeD;
    }
}
