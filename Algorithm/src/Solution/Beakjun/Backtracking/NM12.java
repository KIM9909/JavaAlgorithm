package Solution.Beakjun.Backtracking;
// 15666. N과 M (12)

import java.util.*;
import java.io.*;
public class NM12 {
    static int N, M;
    static int[] arr;
    static ArrayList<Integer> nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nums);

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        int lastNum = 0;
        for (int i=start; i<N; i++) {
            int currentNum = nums.get(i);

            if (currentNum == lastNum) {
                continue;
            }

            arr[depth] = currentNum;
            lastNum = currentNum;
            dfs(i, depth + 1);
        }
    }
}
