package Solution.Beakjun.Backtracking;
// 15663. N과 M (9)

import java.util.*;
import java.io.*;
public class NM9 {
    static int N, M;
    static int[] arr;
    static boolean[] used;
    static ArrayList<Integer> nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        used = new boolean[N];
        nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nums);

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

        int lastUsed = 0;

        for (int i=0; i<N; i++) {
            int currentNum = nums.get(i);

            if (used[i] || lastUsed == currentNum) {
                continue;
            }

            used[i] = true;
            arr[depth] = currentNum;
            lastUsed = currentNum;

            dfs(depth + 1);

            used[i] = false;
        }
    }
}
