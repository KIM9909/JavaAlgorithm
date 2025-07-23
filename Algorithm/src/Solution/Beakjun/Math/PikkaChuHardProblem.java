package Solution.Beakjun.Math;
// 16488. 피카츄가 낸 어려운 문제

import java.util.*;
import java.io.*;
public class PikkaChuHardProblem {
    static Long N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        System.out.println(N * N * K);
    }
}
