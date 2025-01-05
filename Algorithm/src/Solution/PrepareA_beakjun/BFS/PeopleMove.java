package Solution.PrepareA_beakjun.BFS;

import java.util.*;
import java.io.*;

public class PeopleMove {
    static int N;
    static int L;
    static int R;
    static int[][] arr;
    static int[][] check_open;
    static int[][] visited;
    static int cnt_day;
    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        check_open = new int[N][N]; // check_open 배열 선언

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt_day = 0;

        while (true) {
            visited = new int[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        check(i, j); // 국경선이 열리는지 확인
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check_open[i][j] == 1 && visited[i][j] == 0) {
                        if (move(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }
            cnt_day++;
        }

        System.out.println(cnt_day);
    }

    static void check(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int nr = x + dr[k];
            int nc = y + dc[k];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                int diff = Math.abs(arr[x][y] - arr[nr][nc]);
                if (L <= diff && diff <= R) {
                    check_open[x][y] = 1; // 국경선이 열린 곳을 표시
                    return;
                }
            }
        }
    }

    static boolean move(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> list = new LinkedList<>();
        q.offer(new int[]{a, b});
        list.offer(new int[]{a, b});
        visited[a][b] = 1;

        int sum_people = arr[a][b];
        int people_cnt = 1;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int k = 0; k < 4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == 0) {
                    int diff = Math.abs(arr[x][y] - arr[nr][nc]);
                    if (L <= diff && diff <= R) {
                        visited[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                        list.offer(new int[]{nr, nc});
                        sum_people += arr[nr][nc];
                        people_cnt++;
                    }
                }
            }
        }

        if (people_cnt > 1) {
            int divide_people = sum_people / people_cnt;
            while (!list.isEmpty()) {
                int[] pos = list.poll();
                arr[pos[0]][pos[1]] = divide_people;
            }
            return true;
        }
        return false;
    }
}
