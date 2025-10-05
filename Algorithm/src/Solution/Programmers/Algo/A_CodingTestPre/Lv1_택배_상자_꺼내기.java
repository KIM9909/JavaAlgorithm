package Solution.Programmers.Algo.A_CodingTestPre;

import java.util.*;
public class Lv1_택배_상자_꺼내기 {
    public int solution(int n, int w, int num) {
        int h;
        if (n % w != 0) {
            h = n / w + 1;
        } else {
            h = n / w;
        }
        int[][] arr = new int[h][w];

        int number = 1;

        for (int i=0; i<h; i++) {
            if (number > n) {
                break;
            }

            if (i % 2 != 0) {
                for (int j=w-1; j>=0; j--) {
                    if (number <= n) {
                        arr[i][j] = number;
                        number++;
                    }
                }
            } else {
                for (int j=0; j<w; j++) {
                    if (number <= n) {
                        arr[i][j] = number;
                        number++;
                    }
                }
            }
        }

        int res = 0;
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (arr[i][j] == num) {
                    res = count(i, j, h, w, arr);
                    break;
                }
            }
        }

        return res;
    }

    static int count(int a, int b, int h, int w, int[][] arr) {
        int cnt = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            int nr = x + 1;
            int nc = y;

            if (nr < h && arr[nr][nc] != 0) {
                q.offer(new int[] {nr, nc});
                cnt++;
            }
        }

        return cnt;
    }
}
