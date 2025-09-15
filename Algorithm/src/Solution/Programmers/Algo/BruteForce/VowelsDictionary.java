package Solution.Programmers.Algo.BruteForce;
// Lv.2 모음사전

import java.util.*;
public class VowelsDictionary {
    static int cnt;

    public int solution(String word) {
        String[] vowels = {"A", "E", "I", "O", "U"};
        cnt = 0;

        dfs(vowels, word, "");

        return cnt;
    }

    static boolean dfs(String[] vowels, String word, String cur) {
        if (cur.equals(word)) {
            return true;
        }

        if (cur.length() == 5) {
            return false;
        }

        for (String vowel : vowels) {
            cnt++;
            if (dfs(vowels, word, cur + vowel)) {
                return true;
            }
        }

        return false;
    }
}
