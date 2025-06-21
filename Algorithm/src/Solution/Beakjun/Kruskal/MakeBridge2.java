// 17472. 다리 만들기 2 (크루스칼)
package Solution.Beakjun.Kruskal;

import java.io.*;
import java.util.*;
public class MakeBridge2 {
    static int N, M;
    static int[] parent;
    static boolean[][] visited;
    static int[][] arr;
    static PriorityQueue<int[]> pq;
    static ArrayList<ArrayList<int[]>> islands;
    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        islands = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandCnt = 0;
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    islands.add(new ArrayList<>());
                    check(i, j, islandCnt);
                    islandCnt++;
                }
            }
        }

        parent = new int[islandCnt];
        for (int i=0; i<islandCnt; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // 모든 섬에서부터 bfs 수행
        for (int i=0; i<islandCnt; i++) {
            for (int[] current : islands.get(i)) {
                bfs(current[0], current[1], i);
            }
        }

        int res = kruskal();
        System.out.println(res);
    }

    // 섬의 개수 확인 및 해당 섬을 이루는 좌표 저장
    static void check(int a, int b, int islandNum) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        visited[a][b] = true;
        islands.get(islandNum).add(new int[] {a, b});

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < N && 0 <= nc && nc < M && arr[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                    islands.get(islandNum).add(new int[] {nr, nc});
                }
            }
        }
    }

    static void bfs(int a, int b, int startIdx) {
        // 4 방향으로 쭉 다리 놓기
        for (int k=0; k<4; k++) {
            int len = 0;
            int nr = a;
            int nc = b;

            while (true) {
                nr += dr[k];
                nc += dc[k];

                // 범위를 벗어나면 중단
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    break;
                }

                if (arr[nr][nc] == 1) { // 섬을 만났을 경우
                    if (len >= 2) { // 다리 길이가 2이상일 때
                        for (int i=0 ; i<islands.size(); i++) {
                            // 출발한 섬이 아니고, 어떤 섬에 도착했을 경우 간선 추가
                            if (i != startIdx && isInIsland(nr, nc, i)) {
                                pq.offer(new int[] {startIdx, i, len});
                                break;
                            }
                        }
                    }
                    break;
                }
                len++; // 다리 길이 증가
            }
        }
    }

    // 섬에 도착했는지 확인하는 메서드
    static boolean isInIsland(int r, int c, int islandNum) {
        for (int[] pos : islands.get(islandNum)) {
            if (pos[0] == r && pos[1] == c) {
                return true;
            }
        }
        return false;
    }

    // MST
    static int kruskal() {
        int totalWeight = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (find(current[0]) != find(current[1])) {
                union(current[0], current[1]);
                totalWeight += current[2];
                cnt++;
            }
        }
        return cnt == islands.size()-1 ? totalWeight : -1;
    }
}
