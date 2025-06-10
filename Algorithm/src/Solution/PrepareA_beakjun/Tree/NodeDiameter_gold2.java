package Solution.PrepareA_beakjun.Tree;
// 1167. 트리의 지름

import java.io.*;
import java.util.*;
public class NodeDiameter_gold2 {
    static int V;
    static List<List<Edge>> graph;
    static int start, end, distance;
    static int farNode;
    static int maxDistance;
    static boolean[] visited;

    static class Edge {
        int node;
        int distance;

        Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());

            while (true) {
                end = Integer.parseInt(st.nextToken());

                if (end == -1) {
                    break;
                }

                distance = Integer.parseInt(st.nextToken());

                graph.get(start).add(new Edge (end, distance));
                graph.get(end).add(new Edge (start, distance));
            }
        }

        // 루트에서 가장 먼 노드 탐색
        visited = new boolean[V+1];
        maxDistance = 0;
        dfs(1, 0);

        // 가장 먼 노드에서 가장 먼 노드 탐색
        visited = new boolean[V+1];
        maxDistance = 0;
        dfs(farNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farNode = node;
        }

        for (Edge edge : graph.get(node)) {
            if (!visited[edge.node]) {
                visited[edge.node] = true;
                dfs(edge.node, edge.distance + distance);
            }
        }
    }
}
