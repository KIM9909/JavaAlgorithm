package Solution.Beakjun.Sort;
// 11931. 수 정렬하기 4

import java.io.*;
import java.util.*;
public class S5_NumSort4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] nums = new Integer[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(nums[i]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
