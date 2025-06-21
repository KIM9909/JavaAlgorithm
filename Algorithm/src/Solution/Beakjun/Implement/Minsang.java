// 21922. 학부 연구생 민상 (구현)
package Solution.Beakjun.Implement;

import java.util.*;
import java.io.*;
public class Minsang {
    static int N, M;
    static int[][] arr;
    static boolean[][] isSeat;
    static int cntSeat;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        isSeat = new boolean[N+1][M+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (arr[i][j] == 9) {
                    isSeat[i][j] = true;
                    for (int k=0; k<4; k++) {
                        moveAir(i, j, k);
                    }
                }
            }
        }

        cntSeat = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (isSeat[i][j]) {
                    cntSeat += 1;
                }
            }
        }

        System.out.println(cntSeat);
    }

    static void moveAir(int x, int y, int dir) {
        int nr = x + dr[dir];
        int nc = y + dc[dir];

        while (true) {
            if (nr < 1 || nr > N || nc < 1 || nc > M) {
                return;
            }

            if (arr[nr][nc] == 0) {
                isSeat[nr][nc] = true;
                // 다음 위치로 이동
                nr = nr + dr[dir];
                nc = nc + dc[dir];
            } else {
                // 장애물을 만난 경우
                int newDir = changeDir(nr, nc, dir);
                isSeat[nr][nc] = true;

                // changeDir에서 -1을 반환하면 해당 방향으로 더 이상 진행하지 않음
                if (newDir == -1) {
                    return;
                }

                dir = newDir;
                // 방향 변경 후 다음 위치로 이동
                nr = nr + dr[dir];
                nc = nc + dc[dir];
            }
        }
    }

    static int changeDir(int x, int y, int dir) {
        int newDir = -1;
        if (arr[x][y] == 1) {
            if (dir == 0) {
                newDir = dir;
            } else if (dir == 1) {
                newDir = dir + 2;
            } else if (dir == 2) {
                newDir = dir;
            } else {
                newDir = dir - 2;
            }
        } else if (arr[x][y] == 2) {
            if (dir == 0) {
                newDir = dir + 2;
            } else if (dir == 1) {
                newDir = dir;
            } else if (dir == 2) {
                newDir = dir - 2;
            } else {
                newDir = dir;
            }
        } else if (arr[x][y] == 3) {
            if (dir == 0) {
                newDir = dir + 1;
            } else if (dir == 1) {
                newDir = dir - 1;
            } else if (dir == 2) {
                newDir = dir + 1;
            } else {
                newDir = dir - 1;
            }
        } else if (arr[x][y] == 4) {
            if (dir == 0) {
                newDir = dir + 3;
            } else if (dir == 1) {
                newDir = dir + 1;
            } else if (dir == 2) {
                newDir = dir - 1;
            } else {
                newDir = dir - 3;
            }
        } else if (arr[x][y] == 9) {
            // 에어컨을 만났을 경우, 공기 흐름 중단
            return -1;
        }
        return newDir;
    }
}
