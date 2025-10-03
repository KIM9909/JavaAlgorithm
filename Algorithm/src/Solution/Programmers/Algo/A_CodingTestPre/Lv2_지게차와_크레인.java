package Solution.Programmers.Algo.A_CodingTestPre;

import java.util.*;
public class Lv2_지게차와_크레인 {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public int solution(String[] storage, String[] requests) {
        int n = storage.length + 2;
        int m = storage[0].length() + 2;
        String[][] arr = new String[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                arr[i][j] = ".";
            }
        }

        for (int i=1; i<n-1; i++) {
            for (int j=1; j<m-1; j++) {
                arr[i][j] = String.valueOf(storage[i-1].charAt(j-1));
            }
        }

        for (String request : requests) {
            if (request.length() > 1) {
                String req = String.valueOf(request.charAt(0));
                removeAll(req, arr, n, m);
            } else {
                remove(request, arr, n, m);
            }
        }

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!arr[i][j].equals(".")) {
                    cnt ++;
                }
            }
        }

        return cnt;
    }

    static void removeAll(String req, String[][] arr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals(req)) {
                    arr[i][j] = ".";
                }
            }
        }
    }

    static void remove(String request, String[][] arr, int n, int m) {
        // 외부에서 도달 가능한 빈 칸 찾기
        boolean[][] reachable = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                    q.offer(new int[]{i, j});
                    reachable[i][j] = true;
                }
            }
        }

        // BFS로 연결된 모든 빈 칸 찾기
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];

            for (int k=0; k<4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (0 <= nr && nr < n && 0 <= nc && nc < m &&
                        !reachable[nr][nc] && arr[nr][nc].equals(".")) {
                    reachable[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // 외부와 연결된 컨테이너 제거
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i][j].equals(request)) {
                    for (int k=0; k<4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (0 <= nr && nr < n && 0 <= nc && nc < m &&
                                reachable[nr][nc]) {
                            arr[i][j] = ".";
                            break;
                        }
                    }
                }
            }
        }
    }
}
