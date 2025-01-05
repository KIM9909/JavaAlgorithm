// 프림
package Solution.PrepareA_beakjun.Prim;

import java.io.*;
import java.util.*;
public class MakeStarSign {
    static int n;
    static double x, y;
    static boolean[] visited;
    static double[][] stars;
    static double[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 별의 개수

        visited = new boolean[n];
        stars = new double[n][2]; // 0: x좌표, 1: y좌표
        graph = new double[n][n]; // 별들간의 거리를 저장

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken()); // 별의 x좌표
            y = Double.parseDouble(st.nextToken()); // 별의 y좌표
            stars[i][0] = x;
            stars[i][1] = y;
        }

        // 모든 별들 사이의 거리 계산
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                graph[i][j] = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2)
                                    + Math.pow(stars[i][1] - stars[j][1], 2));
            }
        }
        Double res = prim();
        System.out.printf("%.2f%n", res);

    }

    static double prim() {
        double[] minCost = new double[n]; // 각 정점까지의 최소 비용
        Arrays.fill(minCost, Double.MAX_VALUE);
        minCost[0] = 0; // 출발점은 0

        double totalCost = 0;

        // 모든 정점을 순회하면서
        for (int i=0; i<n; i++) {
            int minVertex = -1; // 최소 비용의 정점
            double min = Double.MAX_VALUE; // 최소 비용

            for (int j=0; j<n; j++) {
                if (!visited[j] && minCost[j] < min) {
                    minVertex = j; // 최소 비용의 정점 갱신
                    min = minCost[j]; // 최소 비용 갱신
                }
            }

            visited[minVertex] = true;
            totalCost += min;

            // 새로운 minVertex를 통해 다른 정점들의 비용 갱신
            for (int j=0; j<n; j++) {
                if (!visited[j] && graph[minVertex][j] < minCost[j]) {
                    minCost[j] = graph[minVertex][j];
                }
            }
        }
        return totalCost;
    }
}
