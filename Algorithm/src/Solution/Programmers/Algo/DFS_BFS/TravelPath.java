package Solution.Programmers.Algo.DFS_BFS;

import java.util.*;

// Lv.3 여행경로
public class TravelPath {
    public String[] solution(String[][] tickets) {
        List<String> path = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        // 알파벳 순으로 정렬 시키기
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        // 출발점 저장
        path.add("ICN");
        dfs("ICN", tickets, path, visited);

        return path.toArray(new String[0]);
    }

    static boolean dfs(String cur, String[][] tickets, List<String> path, boolean[] visited) {
        if (path.size() == tickets.length + 1) {
            return true;
        }

        for (int i=0; i<tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                path.add(tickets[i][1]);

                if (dfs(tickets[i][1], tickets, path, visited)) {
                    return true;
                }

                visited[i] = false;
                path.remove(path.size()-1);
            }
        }

        return false;
    }
}
