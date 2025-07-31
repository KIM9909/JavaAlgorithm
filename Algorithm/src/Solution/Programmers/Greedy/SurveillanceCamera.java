package Solution.Programmers.Greedy;
// Lv.3 단속카메라

import java.util.*;
public class SurveillanceCamera {
    List<int[]> sortRoutes = new ArrayList<>();
    static int cnt = 0;
    public int solution(int[][] routes) {
        for (int[] route : routes) {
            sortRoutes.add(route);
        }

        // 진출 지점 기준으로 정렬
        sortRoutes.sort((a, b) -> a[1] - b[1]);

        // 마지막으로 카메라를 설치한 위치
        int camera = Integer.MIN_VALUE;

        for (int i=0; i<sortRoutes.size(); i++) {
            int currEntry = sortRoutes.get(i)[0];
            int currOut = sortRoutes.get(i)[1];

            // 현재 차량이 마지막 카메라 범위를 벗어나면 새 카메라 설치
            if (camera < currEntry) {
                camera = currOut; // 나가는 지점에 카메라 설치
                cnt ++;
            }
        }

        return cnt;
    }
}
