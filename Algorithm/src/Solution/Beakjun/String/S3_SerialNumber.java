package Solution.Beakjun.String;
// 1431. 시리얼 번호

import java.io.*;
import java.util.*;
public class S3_SerialNumber {
    static int N;
    static String[] serialNums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        serialNums = new String[N];

        for (int i=0; i<N; i++) {
            serialNums[i] = br.readLine();
        }

        Arrays.sort(serialNums, (a, b) -> {
            // 1. 길이 비교
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            // 2. 숫자들의 합 비교
            int sumA = getSum(a);
            int sumB = getSum(b);
            if (sumA != sumB) {
                return sumA - sumB;
            }

            // 3. 알파벳 순서 비교
            return a.compareTo(b);
        });

        for (String serial : serialNums) {
            System.out.println(serial);
        }
    }

    static int getSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += (c - '0');
            }
        }

        return sum;
    }
}
