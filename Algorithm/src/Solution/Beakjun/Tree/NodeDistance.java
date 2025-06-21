package Solution.Beakjun.Tree;
// 1240. 노드사이의 거리

import java.io.*;
import java.util.*;
public class NodeDistance {
    static int N, M;
    static int A, B, distance;
    static int start, end;
    static List<List<Edge>> graph; // 인접 리스트로 트리 저장

    // 간선 정보(Edge)를 저장하는 클래스
    static class Edge {
        int targetNode; // 연결된 노드
        int distance; // 거리

        Edge(int targetNode, int distance) {
            this.targetNode = targetNode;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화 (1부터 N까지)
        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph.get(A).add(new Edge(B, distance));
            graph.get(B).add(new Edge(A, distance));
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            int res = bfs(start, end);

            sb.append(res).append('\n');
        }

        System.out.println(sb);
    }

    static int bfs(int start, int end) {
        if (start == end) {
            return 0;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.offer(new int[] {start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            // 현재 노드와 연결된 모든 노드 탐색
            for (Edge edge : graph.get(currentNode)) {
                int nextNode = edge.targetNode;
                int distance = edge.distance;

                // 아직 방문하지 않은 노드인 경우
                if (!visited[nextNode]) {
                    int nextDistance = currentDistance + distance;

                    // 목표 노드에 도착했을 경우
                    if (nextNode == end) {
                        return nextDistance;
                    }

                    visited[nextNode] = true;
                    q.offer(new int[] {nextNode, nextDistance});
                }
            }
        }
        return 0;
    }
}
