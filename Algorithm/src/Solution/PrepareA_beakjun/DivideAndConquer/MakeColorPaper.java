package Solution.PrepareA_beakjun.DivideAndConquer;
// 2630. 색종이 만들기

import java.io.*;
import java.util.*;
public class MakeColorPaper {
    static int N;
    static int[][] arr;
    static int whiteCnt = 0 ;
    static int blueCnt = 0;
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

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    static void divideConquer (int x, int y, int size) {
        // 주어진 영역이 모든 같은 색일 경우
        if (isSameColor(x, y, size)) {
            if (arr[x][y] == 0) {
                whiteCnt ++;
            } else {
                blueCnt ++;
            }
            return;
        }

        // 주어진 영역의 색이 다를 경우 영역 나누기
        int halfSize = size / 2;

        // 좌상단 영역
        divideConquer(x, y, halfSize);

        // 우상단 영역
        divideConquer(x, y + halfSize, halfSize);

        // 좌하단 영역
        divideConquer(x + halfSize, y, halfSize);

        // 우하단 영역
        divideConquer(x + halfSize, y + halfSize, halfSize);
    }

    // 주어진 영역이 모두 같은 색인지 확인
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
