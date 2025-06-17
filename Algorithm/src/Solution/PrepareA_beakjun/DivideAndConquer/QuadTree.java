package Solution.PrepareA_beakjun.DivideAndConquer;
// 1992. 쿼드트리

import java.io.*;
import java.util.*;
public class QuadTree {
    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                arr[i][j] = line.charAt(j) - '0'; // 문자를 숫자로 변환
            }
        }

        divideConquer(0, 0, N);

        System.out.println(sb);
    }

    static void divideConquer(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            if (arr[x][y] == 0) {
                sb.append(0);
            } else {
                sb.append(1);
            }

            return;
        }

        int newSize = size / 2;

        sb.append("(");
        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                divideConquer(x + i*newSize, y + j*newSize, newSize);
            }
        }
        sb.append(")");
    }

    static boolean isSameColor(int x, int y, int size) {
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
