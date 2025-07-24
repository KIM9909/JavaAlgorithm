package Solution.Beakjun.Implement;
// 1018. 체스판 다시 칠하기

import java.util.*;
import java.io.*;
public class ChessPainting {
    static int N, M;
    static char[][] arr;
    static int minPaint = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        // 8 * 8 배열 뽑아서 색칠하기
        for (int i=0; i<=N-8; i++) {
            for (int j=0; j<=M-8; j++) {
                int cnt = paint(i, j);
                minPaint = Math.min(minPaint, cnt);
            }
        }

        System.out.println(minPaint);
    }

    static int paint(int x, int y) {
        int cntW = 0;
        int cntB = 0;

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                char current = arr[x+i][y+j];

                if ((i + j) % 2 == 0) {
                    if (current != 'W') {
                        cntW ++;
                    }
                } else {
                    if (current != 'B') {
                        cntW ++;
                    }
                }

                if ((i + j) % 2 == 0) {
                    if (current != 'B') {
                        cntB ++;
                    }
                } else {
                    if (current != 'W') {
                        cntB ++;
                    }
                }
            }
        }

        return Math.min(cntW, cntB);
    }
}
