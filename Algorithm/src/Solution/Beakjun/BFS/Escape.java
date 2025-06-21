package Solution.Beakjun.BFS;

import java.util.*;
import java.io.*;

public class Escape {
    static int R, C;
    static String[][] arr;
    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};
    static int[][] waterTime;  // 물이 차는 시간을 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[R][C];
        waterTime = new int[R][C];
        int[] start = null;

        for (int i = 0; i < R; i++) {
            Arrays.fill(waterTime[i], Integer.MAX_VALUE);
        }

        // 물의 위치를 저장할 큐
        Queue<int[]> waterQ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
                if (arr[i][j].equals("*")) {
                    waterQ.offer(new int[]{i, j, 0});
                    waterTime[i][j] = 0;
                } else if (arr[i][j].equals("S")) {
                    start = new int[]{i, j};
                }
            }
        }

        // 물 확산 시간 미리 계산
        calculateWaterTime(waterQ);

        // 고슴도치 이동 시작
        int result = bfs(start[0], start[1]);

        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    // 물 확산 시간 계산
    static void calculateWaterTime(Queue<int[]> waterQ) {
        while (!waterQ.isEmpty()) {
            int[] xy = waterQ.poll();
            int x = xy[0];
            int y = xy[1];
            int time = xy[2];

            for (int k = 0; k < 4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < R && 0 <= nc && nc < C &&
                        !arr[nr][nc].equals("X") && !arr[nr][nc].equals("D") &&
                        waterTime[nr][nc] == Integer.MAX_VALUE) {

                    waterTime[nr][nc] = time + 1;
                    waterQ.offer(new int[]{nr, nc, time + 1});
                }
            }
        }
    }

    // 고슴도치 이동을 위한 BFS
    static int bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        q.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            int time = xy[2];

            // 도착지점에 도달한 경우
            if (arr[x][y].equals("D")) {
                return time;
            }

            for (int k = 0; k < 4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < R && 0 <= nc && nc < C &&
                        !visited[nr][nc] && !arr[nr][nc].equals("X")) {

                    // 다음 위치가 물에 잠기기 전에 이동할 수 있는지 확인
                    if (time + 1 < waterTime[nr][nc] || arr[nr][nc].equals("D")) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc, time + 1});
                    }
                }
            }
        }

        return -1;  // 도착지점에 도달할 수 없는 경우
    }
}