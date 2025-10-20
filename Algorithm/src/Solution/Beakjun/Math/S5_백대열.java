package Solution.Beakjun.Math;

import java.io.*;
import java.util.*;
public class S5_백대열 {
    static List<Integer> NM;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String NMs = br.readLine();

        String[] NM = NMs.split(":");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int maxNum = Math.max(N, M);

        for (int i=maxNum; i>0; i--) {
            if (N % i == 0 && M % i == 0) {
                N /= i;
                M /= i;
            }
        }

        sb.append(N).append(":").append(M);

        System.out.println(sb);
    }
}
