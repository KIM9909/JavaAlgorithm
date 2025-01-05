package Solution.PrepareA_beakjun.Implement;

import java.io.*;
import java.util.*;
public class Snake {
    static int N, K;
    static Queue<int[]> applePoint;
    static HashMap<Integer, String> directionChange;
    static Queue<int[]> snakePos;
    static int L;
    static int X;
    static String C;
    static int[][] arr;
    static int final_cnt;
    static int[] dr = {0,1,0,-1}; // 우, 하, 좌, 상
    static int[] dc = {1,0,-1,0};
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        final_cnt = 0;

        applePoint = new LinkedList<>(); // 사과 위치 정보
        directionChange = new HashMap<>(); // 방향 전환 정보
        snakePos = new LinkedList<>(); // 뱀위 이동 위치 저장

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            applePoint.offer(new int[] {r,c});
        }

        L = Integer.parseInt(br.readLine());

        for (int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            C = st.nextToken();
            directionChange.put(X, C);
        }

        arr = new int[N][N];

        // 사과 위치 저장
        while (!applePoint.isEmpty()) {
            int[] xy = applePoint.poll();
            int x = xy[0];
            int y = xy[1];
            arr[x-1][y-1] = 2;
        }

        // 뱀 초기 위치
        arr[0][0] = 1;
        snakePos.offer(new int[] {0,0});

        // 뱀 이동
        moveSnake(0, 0);

        System.out.println(final_cnt);
    }

    static void moveSnake(int x, int y) {
        k = 0;
        int cnt = 0;

        while (true) {
            // 특정 시간마다 방향 전환
            if (directionChange.containsKey(cnt)) {
                String direction = directionChange.get(cnt);
                if (direction.equals("D")) {
                    k = (k+1) % 4; // 오른쪽
                } else if (direction.equals("L")) {
                    k = (k+3) % 4; // 왼쪽
                }
            }

            int nr = x + dr[k];
            int nc = y + dc[k];

            if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                if (arr[nr][nc] == 0) {
                    arr[nr][nc] = 1;
                    snakePos.offer(new int[] {nr, nc});
                    // 꼬리 줄어듦
                    int[] snakeTail = snakePos.poll();
                    arr[snakeTail[0]][snakeTail[1]] = 0;
                    final_cnt ++;
                    cnt ++;
                    x = nr;
                    y = nc;
                } else if (arr[nr][nc] == 2) {
                    arr[nr][nc] = 1;
                    snakePos.offer(new int[] {nr, nc});
                    final_cnt ++;
                    cnt ++;
                    x = nr;
                    y = nc;
                } else { // 자기 몸통에 도달할 경우
                    final_cnt ++;
                    break;
                }
            } else { // 벽에 도달할 경우
                final_cnt ++;
                break;
            }
        }
    }
}
