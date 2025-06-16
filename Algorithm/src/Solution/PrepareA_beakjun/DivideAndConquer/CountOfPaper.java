package Solution.PrepareA_beakjun.DivideAndConquer;
// 1780. 종이의 개수

import java.io.*;
import java.util.*;
public class CountOfPaper {
    static int N;
    static int[][] arr;
    static int minus = 0, zero = 0, one = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideConquer(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    static void divideConquer (int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            if (arr[x][y] == -1) {
                minus ++;
            } else if (arr[x][y] == 0) {
                zero ++;
            } else {
                one ++;
            }

            return;
        }

        int newSize = size / 3;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                divideConquer(x + i*newSize, y + j*newSize, newSize);
            }
        }
    }

    static boolean isSameColor (int x, int y, int size) {
        int color = arr[x][y];

        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
