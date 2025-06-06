package Solution.PrepareA_beakjun.Tree;
// 24230. 트리 색칠하기

import java.io.*;
import java.util.*;
public class TreeColoring {
    static int N;
    static int A, B;
    static int[] nodesColor;
    static int color;
    static List<List<Edge>> graph;
    static boolean[] visited;
    static int coloringCnt = 0;

    static class Edge {
        int targetNode;

        Edge(int targetNode) {
            this.targetNode = targetNode;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        nodesColor = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            color = Integer.parseInt(st.nextToken());
            nodesColor[i] = color;
        }

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Edge(B));
            graph.get(B).add(new Edge(A));
        }

        visited = new boolean[N+1];

        // 1번 노드가 0이 아니면 칠하고 시작
        if (nodesColor[1] != 0) {
            coloringCnt ++;
        }

        visited[1] = true;
        dfs(1, nodesColor[1]); // 현재 노드, 부모의 색깔

        System.out.println(coloringCnt);
    }

    static void dfs(int currentNode, int parentColor) {
        // 현재 노드와 연결된 노드 탐색
        for (Edge edge : graph.get(currentNode)) {
            int nextNode = edge.targetNode;

            if (!visited[nextNode]) {
                visited[nextNode] = true;

                // 부모의 색과 다른 색이면 칠하기 카운트 증가
                if (parentColor != nodesColor[nextNode]) {
                    coloringCnt ++;
                }

                dfs(nextNode, nodesColor[nextNode]);
            }
        }
    }
}
