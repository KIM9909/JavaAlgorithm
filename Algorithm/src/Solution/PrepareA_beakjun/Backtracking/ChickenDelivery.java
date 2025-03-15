// 15868. 치킨배달 (구현, 브루트포스, 백트래킹)
package Solution.PrepareA_beakjun.Backtracking;

import java.io.*;
import java.util.*;
public class ChickenDelivery {
    static int N, M;
    static int[][] arr;
    static int cityDist;
    static ArrayList<int[]> homeLocation;
    static ArrayList<int[]> chickenLocation;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        homeLocation = new ArrayList<>();
        chickenLocation = new ArrayList<>();
        cityDist = Integer.MAX_VALUE;

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (arr[i][j] == 1) {
                    homeLocation.add(new int[] {i, j});
                } else if (arr[i][j] == 2) {
                    chickenLocation.add(new int[] {i, j});
                }
            }
        }

        selected = new boolean[chickenLocation.size()];

        // 백트래킹으로 M개의 치킨 집 선택
        selectChicken(0, 0, selected);

        System.out.println(cityDist);
    }

    static void selectChicken(int start, int count, boolean[] selected) {

        if (count == M) {
            int totalDist = calChickenDist(selected);

            cityDist = Math.min(cityDist, totalDist);
            return;
        }

        for (int i=start; i<chickenLocation.size(); i++) {
            selected[i] = true;
            selectChicken(i+1, count+1, selected);
            selected[i] = false;
        }
    }

    static int calChickenDist(boolean[] selected) {
        int totalDistance = 0;

        for (int[] home : homeLocation) {
            int minDist = Integer.MAX_VALUE;

            for (int i=0; i<chickenLocation.size(); i++) {
                if (selected[i]) {
                    int[] chicken = chickenLocation.get(i);

                    minDist = Math.min(minDist, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
                }
            }
            totalDistance += minDist;
        }
        return totalDistance;
    }
}
