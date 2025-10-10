package Solution.Beakjun.Sort;

import java.io.*;
import java.util.*;
public class S5_점수_계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<int[]> lst = new ArrayList<>();

        for (int i=1; i<=8; i++) {
            int score = Integer.parseInt(br.readLine());
            lst.add(new int[] {i, score});
        }

        Collections.sort(lst, (a, b) -> {
            return b[1] - a[1];
        });

        int totalScore = 0;
        int[] sortIdx = new int[5];
        for (int i=0; i<5; i++) {
            totalScore += lst.get(i)[1];

            sortIdx[i] = lst.get(i)[0];
        }

        Arrays.sort(sortIdx);

        for (int i=0; i<5; i++) {
            sb.append(sortIdx[i]).append(" ");
        }

        System.out.println(totalScore);
        System.out.println(sb.toString());
    }
}
