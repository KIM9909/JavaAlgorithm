package Solution.Beakjun.Geometry;
// 1004. 어린 왕자

import java.io.*;
import java.util.*;
public class LittlePrince {
    static int T;
    static int n;
    static int x1, y1, x2, y2;
    static int cx, cy, r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            n = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                cx = Integer.parseInt(st.nextToken());
                cy = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());

                // 출발점과 도착점이 같은 원 안에 있는지 확인
                boolean startPoint = checkSameInside(x1, y1, cx, cy, r);
                boolean endPoint = checkSameInside(x2, y2, cx, cy, r);

                // 다르다면 진입/이탈 카운트 증가
                if (startPoint != endPoint) {
                    cnt ++;
                }
            }

            System.out.println(cnt);
        }
    }

    static boolean checkSameInside(int x, int y, int cx, int cy, int r) {
        int dx = x - cx; // x 방향 거리
        int dy = y - cy; // y 방향 거리

        // 반지름의 제곱이 더 크다면 원 안에 있는 것
        return (dx * dx + dy * dy) < (r * r);
    }
}
