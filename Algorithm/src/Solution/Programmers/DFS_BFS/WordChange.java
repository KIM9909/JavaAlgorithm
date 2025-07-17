package Solution.Programmers.DFS_BFS;
// Lv3. 단어 변환

import java.util.*;
public class WordChange {
    static int cnt = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {

        boolean hasTarget = false;
        for (String word : words) {
            if (word.equals(target)) {
                hasTarget = true;
                break;
            }
        }
        if (!hasTarget) {
            return 0;
        }

        boolean[] visited = new boolean[words.length];
        dfs(visited, begin, target, words, 0);

        return cnt;
    }

    static void dfs(boolean[] visited, String begin, String target, String[] words, int depth) {
        if (begin.equals(target)) {
            cnt = Math.min(cnt, depth);
            return;
        }

        for (int i=0; i< words.length; i++) {
            if (!visited[i] && differ(begin, words[i]) == 1) {
                visited[i] = true;
                dfs(visited, words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }

    static int differ(String begin, String word) {
        int differCnt = 0;

        for (int i=0; i<begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                differCnt ++;
            }
        }

        return differCnt;
    }
}
