package Solution.PrepareA_beakjun.Tree;
// 1967. 트리의 지름

import java.io.*;
import java.util.*;
public class TreeDiameter {
    static int n;
    static int parent, child, weight;
    static List<List<Edge>> graph;
    static boolean[] visited;
    static int maxDistance;
    static int farNode;

    static class Edge {
        int node;
        int w;

        Edge(int node, int w) {
            this.node = node;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            parent = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            graph.get(parent).add(new Edge(child, weight));
            graph.get(child).add(new Edge(parent, weight));
        }

        // 1. 1번 노드에서 가장 먼 노드 찾기
        visited = new boolean[n+1];
        maxDistance = 0;
        dfs(1, 0);

        // 2. 가장 먼 노드에서 가장 먼 노드 찾기
        visited = new boolean[n+1];
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
                dfs(edge.node, distance + edge.w);
            }
        }
    }
}
