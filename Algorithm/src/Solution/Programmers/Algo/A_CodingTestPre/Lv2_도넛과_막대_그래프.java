package Solution.Programmers.Algo.A_CodingTestPre;

import java.util.*;
public class Lv2_도넛과_막대_그래프 {
    public int[] solution(int[][] edges) {
        // 도넛 그래프 : 진입 차수와 진출 차수가 1
        // 막대 그래프 : 마지막 정점의 진출 차수가 0
        // 8자 그래프 : 중심 정점의 진입, 진출 차수가 2

        Map<Integer, Integer> inDegree = new HashMap<>(); // 진입 차수
        Map<Integer, Integer> outDegree = new HashMap<>(); // 진출 차수

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            // 진출 차수 증가
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);

            // 진입 차수 증가
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);

            // 진입 및 진출 차수가 없는 경우도 정점 등록
            outDegree.putIfAbsent(end, 0);
            inDegree.putIfAbsent(start, 0);
        }

        // 생성된 정점
        int createdV = 0;
        int totalGraph = 0; // 새로운 정점에서 뻗어나가는 간선 수 = 전체 그래프 수

        for (int v : outDegree.keySet()) {
            // 생성된 정점은 진입 0, 진출 2 이상
            if (inDegree.get(v) == 0 && outDegree.get(v) >= 2) {
                createdV = v;
                totalGraph = outDegree.get(v);
                break;
            }
        }

        int barGraph = 0;
        int eightGraph = 0;

        for (int v : outDegree.keySet()) {
            if (v == createdV) {
                continue;
            }

            int in = inDegree.get(v);
            int out = outDegree.get(v);

            if (out == 0) {
                barGraph ++;
            } else if (in >= 2 && out == 2) {
                eightGraph ++;
            }
        }

        int donutGraph = totalGraph - barGraph - eightGraph;

        return (new int[] {createdV, donutGraph, barGraph, eightGraph});
    }
}
