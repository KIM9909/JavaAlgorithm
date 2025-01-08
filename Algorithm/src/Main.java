import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int num, A, B;
    static int[] parent;
    static ArrayList<int[]> graph;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        parent = new int[N+1];
        for (int i=0; i<=N; i++) {
            parent[i] = i;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            graph.add(new int[] {num, A, B});
        }

        StringBuilder sb = new StringBuilder();

        for (int[] temp : graph) {
            int num = temp[0];
            int a = temp[1];
            int b = temp[2];

            if (num == 0 && find(a) != find(b)) {
                union(a, b);
            } else if (num == 1) {
                boolean isSame = true;
                if (!check(a, b)) {
                    isSame = false;
                }
                if (!isSame) {
                    sb.append("NO").append('\n');
                } else {
                    sb.append("YES").append('\n');
                }
            }
        }
        System.out.println(sb);
    }
    static boolean check(int a, int b) {
        if (find(a) != find(b)) {
            return false;
        } else {
            return  true;
        }
    }
}