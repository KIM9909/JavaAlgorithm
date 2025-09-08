package Solution.Beakjun.Greedy;
// 1080. Silver1_행렬

import java.io.*;
import java.util.*;
public class S1_Matrix {
    static int N, M;
    static int[][] A, B;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                B[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i=0; i<=N-3; i++) {
            for (int j=0; j<=M-3; j++) {
                if (A[i][j] != B[i][j]) {
                    flip(i ,j);
                    cnt ++;
                }
            }
        }

        if (isSame()) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }

    static void flip(int r, int c) {
        for (int i=r; i<r+3; i++) {
            for (int j=c; j<c+3; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }
    }

    static boolean isSame() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
