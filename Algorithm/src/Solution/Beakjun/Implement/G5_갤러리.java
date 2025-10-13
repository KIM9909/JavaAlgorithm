package Solution.Beakjun.Implement;

import java.io.*;
import java.util.*;
public class G5_갤러리 {
    static int M, N;
    static String[][] arr;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new String[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        // 가로 방향
        int len1 = 0;
        int len2 = 0;
        for (int i=0; i<M-1; i++) {
            for (int j=0; j<N; j++) {
                // 위쪽 벽, 아래쪽 빈 공간
                if (arr[i][j].equals("X") && arr[i + 1][j].equals(".")) {
                    len1++;
                } else {
                    res += len1 / 2;  // 연속된 경계선 길이 / 2 = 그림 개수
                    len1 = 0;
                }

                // 위쪽 빈 공간, 아래쪽 벽
                if (arr[i][j].equals(".") && arr[i + 1][j].equals("X")) {
                    len2++;
                } else {
                    res += len2 / 2;
                    len2 = 0;
                }
            }
        }

        // 세로 방향
        len1 = 0;
        len2 = 0;
        for (int j=0; j<N-1; j++) {
            for (int i=0; i<M; i++) {
                // 왼쪽 벽, 오른쪽 빈 공간
                if (arr[i][j].equals("X") && arr[i][j + 1].equals(".")) {
                    len1++;
                } else {
                    res += len1 / 2;
                    len1 = 0;
                }

                // 왼쪽 빈 공간, 오른쪽 벽
                if (arr[i][j].equals(".") && arr[i][j + 1].equals("X")) {
                    len2++;
                } else {
                    res += len2 / 2;
                    len2 = 0;
                }
            }
        }

        System.out.println(res);
    }
}