package Solution.Beakjun.BFS;
// 22944. 죽음의 비

import java.util.*;
import java.io.*;
public class DeathRain {
    static int N;
    static int minMove = Integer.MAX_VALUE;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 변의 길이
        int H = Integer.parseInt(st.nextToken()); // 체력
        int D = Integer.parseInt(st.nextToken()); // 우산의 내구도

        String[][] arr = new String[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        // S = 현재 위치, . = 빈칸, U = 우산, E = 안전 지대
        // 안전지대로 도착하면 성공, 이전에 체력이 0이 되면 실패
        // 우산이 있을 때는 체력대신 우산의 내구도가 감소함
        // 우산을 획득할 때, 이미 들고 있는 우산이 있으면 새로운 우산을 선택

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j].equals("S")) {
                    if (bfs(i, j, H, D, arr)) {
                        System.out.println(minMove);
                    } else {
                        System.out.println(-1);
                    }
                    return;
                }
            }
        }
    }

    static boolean bfs(int a, int b, int H, int D, String[][] arr) {
        // 각 위치에서의 최대 생존력(체력+우산내구도)을 저장
        int[][] maxSurvival = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(maxSurvival[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b, 0, H, 0});
        maxSurvival[a][b] = H;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int moveCnt = current[2];
            int health = current[3];
            int umbrellaD = current[4];

            if (arr[x][y].equals("E")) {
                minMove = Math.min(minMove, moveCnt);
                return true;
            }

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                    int newH = health;
                    int newD = umbrellaD;

                    // 우산을 발견한 경우
                    if (arr[nr][nc].equals("U")) {
                        newD = D; // 새로운 우산으로 교체
                    }
                    // 빈 칸이나 안전지대로 이동하는 경우
                    else if (arr[nr][nc].equals(".") || arr[nr][nc].equals("E")) {
                        if (newD > 0) {
                            newD--; // 우산 내구도 감소
                        } else {
                            newH--; // 체력 감소
                            if (newH <= 0) {
                                continue; // 체력이 0이 되면 이동 불가
                            }
                        }
                    }

                    // 현재 위치에서의 생존력이 이전보다 좋은 경우만 진행
                    int survival = newH + newD;
                    if (survival > maxSurvival[nr][nc]) {
                        maxSurvival[nr][nc] = survival;
                        q.offer(new int[] {nr, nc, moveCnt + 1, newH, newD});
                    }
                }
            }
        }

        return false;
    }
}