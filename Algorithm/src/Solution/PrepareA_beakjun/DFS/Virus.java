// dfs
package Solution.PrepareA_beakjun.DFS;

import java.util.*;
import java.io.*;
public class Virus {
    static int Computer, Connect, a, b;
    static int cnt;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Computer = Integer.parseInt(br.readLine());
        Connect = Integer.parseInt(br.readLine());
        cnt =  0;
        visited = new boolean[Computer + 1];

        List<int[]>[] graph = new ArrayList[Computer+1];
        for (int i=1; i<=Computer; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<Connect; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(new int[] {b});
            graph[b].add(new int[] {a});
        }
        visited[1] = true;
        dfs(1, graph);
        System.out.println(cnt);
    }
    static void dfs(int start, List<int[]>[] graph) {
        for (int[] next : graph[start]) {
            int nextStart = next[0];

            if (!visited[nextStart]) {
                visited[nextStart] = true;
                cnt ++;
                dfs(nextStart, graph);
            }
        }
    }
}
