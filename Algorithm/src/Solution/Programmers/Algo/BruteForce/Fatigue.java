package Solution.Programmers.Algo.BruteForce;
// Lv.2 피로도

import java.util.*;
public class Fatigue {
    static int maxCnt = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        // 던전의 순서 순열 생성
        makeComb(dungeons, visited, k, 0);

        return maxCnt;
    }

    static void makeComb (int[][] dungeons, boolean[] visited, int k, int cnt) {
        maxCnt = Math.max(maxCnt, cnt);

        for (int i=0; i< visited.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                makeComb(dungeons, visited, k-dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}
