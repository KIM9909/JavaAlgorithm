package Solution.Beakjun.Implement;

import java.io.*;
import java.util.*;
public class S5_색종이 {
    static int N;
    static int a, b;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[101][101];
        N = Integer.parseInt(br.readLine());

        for (int t=0; t<N; t++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for (int i=a; i<a+10; i++) {
                for (int j=b; j<b+10; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        long cnt = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    cnt ++;
                }
            }
        }

        System.out.println(cnt);
    }
}
