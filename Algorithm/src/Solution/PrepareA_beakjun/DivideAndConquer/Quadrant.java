package Solution.PrepareA_beakjun.DivideAndConquer;
// 1891. 사분면

import java.io.*;
import java.util.*;
public class Quadrant {
    static int d;
    static long size;
    static String number;
    static long x, y, curX, curY;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        number = st.nextToken();

        size = (long) Math.pow(2, d);

        st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

        findPos(0, 0, size, 0);

        // x와 y의 크기 만큼 칸 이동
        curX += x;
        curY -= y; // y 축은 위쪽이 + 이므로 (-)

        // 도착 위치가 범위 내에 있는지 확인
        if (curX < 0 || curX >= size || curY < 0 || curY >= size) {
            System.out.println(-1);
            return;
        }

        // 도착 위치의 사분면 좌표를 숫자로 만들기
        makeNumber(0, 0, size, 0);
        System.out.println(sb.toString());
    }

    // 출발점이 있는 사분면 위치 찾기
    static void findPos (long startX, long startY, long size, int depth) {
        if (depth == d) {
            curX = startX;
            curY = startY;
            return;
        }

        long newSize = size / 2;
        int quadrant = number.charAt(depth) - '0';

        switch (quadrant) {
            case 1: // 오른쪽 위
                findPos(startX + newSize, startY, newSize, depth + 1);
                break;
            case 2: // 왼쪽 위
                findPos(startX, startY, newSize, depth + 1);
                break;
            case 3: // 왼쪽 아래
                findPos(startX, startY + newSize, newSize, depth + 1);
                break;
            case 4: // 오른쪽 아래
                findPos(startX + newSize, startY + newSize, newSize, depth + 1);
                break;
        }
    }

    static void makeNumber (long startX, long startY, long size, int depth) {
        if (depth == d) {
            return;
        }

        long newSize = size / 2;
        long midX = startX + newSize; // X 중간 위치
        long midY = startY + newSize; // Y 중간 위치

        if (curX >= midX && curY < midY) { // 오른쪽 위
            sb.append("1");
            makeNumber(midX, startY, newSize, depth + 1);
        } else if (curX < midX && curY < midY) { // 왼쪽 위
            sb.append("2");
            makeNumber(startX, startY, newSize, depth + 1);
        } else if (curX < midX && curY >= midY) { // 왼쪽 아래
            sb.append("3");
            makeNumber(startX, midY, newSize, depth + 1);
        } else { // 오른쪽 아래
            sb.append("4");
            makeNumber(midX, midY, newSize, depth + 1);
        }
    }
}
