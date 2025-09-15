package Solution.Programmers.Algo.Graph;
// Lv.5 방의 개수

import java.util.*;
public class Lv5_CountOfRoom {
    static int[] dr = {1,1,0,-1,-1,-1,0,1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    public int solution(int[] arrows) {
        Set<String> visitedNodes = new HashSet<>();
        Set<String> visitedEdges = new HashSet<>();

        int r = 0;
        int c = 0;
        visitedNodes.add(r + "," + c);

        for (int arrow : arrows) {
            // 대각선의 교차점 처리를 위해 두 번에 나눠서 이동
            for (int i=0; i<2; i++) {
                int nr = r + dr[arrow];
                int nc = c + dc[arrow];

                String currentNode = r + "," + c;
                String nextNode = nr + "," + nc;
                String edge = currentNode + "->" + nextNode;

                visitedNodes.add(nextNode);
                visitedEdges.add(edge);
                visitedEdges.add(nextNode + "->" + currentNode); // 양방향 저장

                r = nr;
                c = nc;
            }
        }

        // 오일러 공식 (V - E + F = 2)
        // F(면의 수) = E(간선 수) - V(정점 수) + 2
        // 양방향 저장이었기 때문에 / 2, 외부 면은 제외하기 때문에 -1
        int faceCnt = visitedEdges.size() / 2 - visitedNodes.size() + 1;

        return faceCnt;
    }
}
