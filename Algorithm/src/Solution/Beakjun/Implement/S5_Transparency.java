package Solution.Beakjun.Implement;
// 1531. Silver5_투명

import java.io.*;
import java.util.*;
public class S5_Transparency {
    static int N, M;
    static int x1,y1,x2,y2;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[101][101];

        for (int k=0; k<N; k++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int i=y1; i<=y2; i++) {
                for (int j=x1; j<=x2; j++) {
                    arr[i][j] += 1;
                }
            }
        }

        int res = 0;

        for (int i=1; i<101; i++) {
            for (int j=1; j<101; j++) {
                if (arr[i][j] > M) {
                    res ++;
                }
            }
        }

        System.out.println(res);
    }
}
