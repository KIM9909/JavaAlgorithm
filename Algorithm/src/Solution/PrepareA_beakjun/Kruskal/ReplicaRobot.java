// 1944. 복제 로봇 (크루스칼)
package Solution.PrepareA_beakjun.Kruskal;

import java.io.*;
import java.util.*;
public class ReplicaRobot {
    static int N, M;
    static char[][] arr;
    static int[] parent;
    static boolean[][] visited;
    static ArrayList<int[]> keys;
    static PriorityQueue<int[]> pq;
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

        arr = new char[N][N];
        keys = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'K' || arr[i][j] == 'S') {
                    keys.add(new int[] {i, j}); // 시작점과 열쇠 위치 저장
                }
            }
        }

        // keys 크기만큼 설정 및 초기화
        parent = new int[keys.size()];
        for (int i=0; i< keys.size(); i++) {
            parent[i] = i;
        }

        // 간선 정보 저장
        pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // 각 시작점 및 열쇠위치에서 BFS 수행
        for (int i=0; i< keys.size(); i++) {
            int[] current = keys.get(i);
            bfs(current[0], current[1], i);
        }

        // 최소 이동 거리 계산
        int res = kruskal();
        System.out.println(res);
    }

    static void bfs(int a, int b, int startIdx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b, 0});
        visited = new boolean[N][N];
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            int dist = xy[2];

            for (int k=0; k<4; k++) {
                int nr = x + dr[k];
                int nc = y + dc[k];

                if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && arr[nr][nc] != '1') {
                    if (arr[nr][nc] == '0') {
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc, dist+1});
                    } else if (arr[nr][nc] == 'K' || arr[nr][nc] == 'S') {
                        visited[nr][nc] = true;
                        // 해당 위치의 인덱스를 찾아서 간선 정보에 저장
                        for (int j=0; j<keys.size(); j++) {
                            if (keys.get(j)[0] == nr && keys.get(j)[1] == nc) {
                                pq.offer(new int[] {startIdx, j, dist+1});
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    static int kruskal() {
        int totalWeight = 0;
        int cnt = 0;

        while (!pq.isEmpty() && cnt < M) {
            int[] current = pq.poll();

            if (find(current[0]) != find(current[1])) {
                union(current[0], current[1]);
                totalWeight += current[2];
                cnt++;
            }
        }
        // 모든 열쇠를 연결할 수 있으면 총 거리 반환, 아니면 -1 반환
        return cnt == keys.size()-1 ? totalWeight : -1;
    }
}
