// 프림 (1774. 우주신과의 교감)
package Solution.Beakjun.Prim;

import java.util.*;
import java.io.*;
public class BBangSang {
    static int N, M;
    static int X, Y;
    static int connectV1, connectV2;
    static double[][] graph;
    static int[][] gods;
    static boolean[] visited;
    static ArrayList<int[]> connected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gods = new int[N+1][2]; // 우주신들의 좌표
        graph = new double[N+1][N+1]; // 우주신들간의 거리
        visited = new boolean[N+1];
        connected = new ArrayList<>(); // 이미 연결된 정점들

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            gods[i][0] = X;
            gods[i][1] = Y;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            connectV1 = Integer.parseInt(st.nextToken());
            connectV2 = Integer.parseInt(st.nextToken());
            connected.add(new int[] {connectV1, connectV2});
        }

        // 각 거리 구하기
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                graph[i][j] = Math.sqrt(Math.pow(gods[i][0] - gods[j][0], 2)
                                    + Math.pow(gods[i][1] - gods[j][1], 2));
            }
        }

        double res = prim();
        System.out.printf("%.2f%n", res);
    }

    static double prim() {
        double[] minCost = new double[N+1];
        Arrays.fill(minCost, Double.MAX_VALUE);
        minCost[1] = 0;

        double totalCost = 0; // 총 비용

        for (int i=1; i<=N; i++) {
            int minVertex = -1;
            double min = Double.MAX_VALUE;

            for (int j=1; j<=N; j++) {
                if (!visited[j] && minCost[j] < min) {
                    minVertex = j; // 최소 비용 정점 갱신
                    min = minCost[j]; // 최소 비용 갱신
                }
            }
            visited[minVertex] = true;
            totalCost += min;

            // 선택된 정점과 연결된 다른 정점들의 비용 갱신
            for (int j=1; j<=N; j++) {
                if (!visited[j]) {
                    boolean isConnected = false;
                    // 이미 연결된 통로인지 확인
                    for (int[] c : connected) {
                        if ((c[0] == minVertex && c[1] == j) ||
                            c[1] == minVertex && c[0] == j) {
                            isConnected = true;
                            break;
                        }
                    }
                    // 이미 연결된 통로면 비용 0, 아니면 거리 사용
                    double cost;
                    if (isConnected) {
                        cost = 0;
                    } else {
                        cost = graph[minVertex][j];
                    }
                    if (cost < minCost[j]) {
                        minCost[j] = cost;
                    }
                }
            }
        }
        return totalCost;
    }
}
