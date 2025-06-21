package Solution.Beakjun.Backtracking;
// 15654. N과 M (5)

import java.util.*;
import java.io.*;
public class NM5 {
    static int N, M;
    static int[] arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> N_nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        N_nums = new ArrayList<>();
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            N_nums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(N_nums);

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i=0; i<N; i++) {
            if (!used[i]) {
                used[i] = true;
                int num = N_nums.get(i);
                arr[depth] = num;
                dfs(depth+1);
                used[i] = false;
            }
        }
    }
}
