package Solution.Programmers.Algo.A_CodingTestPre;

import java.util.*;
public class Lv2_충돌위험_찾기 {
    static int collisionCnt; // 충돌 횟수
    public int solution(int[][] points, int[][] routes) {
        collisionCnt = 0;

        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for (int[] point : points) {
            int r = point[0];
            int c = point[1];

            maxRow = Math.max(maxRow, r);
            maxCol = Math.max(maxCol, c);
        }

        int[][] arr = new int[maxRow+1][maxCol+1];

        // arr에 포인트 체크
        int idx = 1;
        for (int[] point : points) {
            int r = point[0];
            int c = point[1];

            arr[r][c] = idx;
            idx ++;
        }

        List<List<int[]>> allPath = new ArrayList<>();

        for (int[] route : routes) {
            List<int[]> robotPath = new ArrayList<>();

            for (int i=0; i<route.length; i++) {
                int point = route[i];

                for (int r=0; r<arr.length; r++) {
                    for (int c=0; c<arr[0].length; c++) {
                        if (arr[r][c] == point) {
                            if (i == 0) {
                                robotPath.add(new int[] {r, c});
                            } else {
                                int[] prevPos = robotPath.get(robotPath.size() - 1);
                                move(prevPos[0], prevPos[1], r, c, robotPath);
                            }
                        }
                    }
                }
            }

            allPath.add(robotPath);
        }

        int maxTime = 0;
        for (List<int[]> path : allPath) {
            maxTime = Math.max(maxTime, path.size());
        }

        for (int i=0; i<maxTime; i++) {
            Map<String, Integer> map = new HashMap<>();

            for (List<int[]> path : allPath) {
                if (i < path.size()) {
                    int[] pos = path.get(i);
                    String key = pos[0] + "," + pos[1];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }

            for (int cnt : map.values()) {
                if (cnt >= 2) {
                    collisionCnt ++;
                }
            }
        }

        return collisionCnt;
    }

    static void move(int r, int c, int endR, int endC, List<int[]> robotPath) {

        while (r != endR) {
            if (r < endR) {
                r ++;
            } else {
                r --;
            }

            robotPath.add(new int[] {r, c});
        }

        while (c != endC) {
            if (c < endC) {
                c ++;
            } else {
                c --;
            }

            robotPath.add(new int[] {r, c});
        }
    }
}
