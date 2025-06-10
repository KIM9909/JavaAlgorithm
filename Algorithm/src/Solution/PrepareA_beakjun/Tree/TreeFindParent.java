package Solution.PrepareA_beakjun.Tree;
// 11725. 트리의 부모 찾기

import java.io.*;
import java.util.*;
public class TreeFindParent {
    static int N;
    static int start, end;
    static List<List<Integer>> graph;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        parents = new int[N+1];
        visited = new boolean[N+1];

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        dfs(1);

        for (int i=2; i<=N; i++) {
            sb.append(parents[i]).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs (int node) {
        visited[node] = true;

        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                parents[nextNode] = node;
                dfs(nextNode);
            }
        }
    }
}
