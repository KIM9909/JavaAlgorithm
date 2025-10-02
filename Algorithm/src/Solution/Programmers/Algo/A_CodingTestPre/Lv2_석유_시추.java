package Solution.Programmers.Algo.A_CodingTestPre;

import java.util.*;
public class Lv2_석유_시추 {
    static int maxAmount = Integer.MIN_VALUE;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] land;
    static int[][] groupId;
    static Map<Integer, Integer> groupSize;
    public int solution(int[][] land) {
        this.land = land;

        groupId = new int[land.length][land[0].length];
        groupSize = new HashMap<>();

        int curGroupId = 1;
        // 미리 그룹들의 석유 양을 저장
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                if (land[i][j] == 1 && groupId[i][j] == 0) {
                    int size = bfs(i, j, curGroupId);
                    groupSize.put(curGroupId, size);
                    curGroupId ++;
                }
            }
        }

        // 각 열마다 지나가는 그룹들의 합 계산
        for (int i=0; i<land[0].length; i++) {
            Set<Integer> visitedGroup = new HashSet<>();
            int totalAmount = 0;

            for (int j=0; j<land.length; j++) {
                int gId = groupId[j][i];

                if (0 < gId && !visitedGroup.contains(gId)) {
                    visitedGroup.add(gId);
                    totalAmount += groupSize.get(gId);
                }
            }

            maxAmount = Math.max(maxAmount, totalAmount);
        }

        return maxAmount;
    }

    // 그룹의 석유 양 측정
    static int bfs(int a, int b, int curGroupId) {
        groupId[a][b] = curGroupId;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < land.length && 0 <= nc && nc < land[0].length &&
                        groupId[nr][nc] == 0 && land[nr][nc] == 1) {
                    groupId[nr][nc] = curGroupId;
                    q.offer(new int[] {nr, nc});
                    cnt ++;
                }
            }
        }

        return cnt;
    }
}
