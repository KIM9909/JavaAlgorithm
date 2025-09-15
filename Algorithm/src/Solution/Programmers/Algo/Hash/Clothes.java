package Solution.Programmers.Algo.Hash;
// Lv.2 의상

import java.util.*;
class Clothes {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        // 각 의상 종류별로 개수 세기
        for (String[] cloth : clothes) {
            String cloth_kind = cloth[1];

            map.put(cloth_kind, map.getOrDefault(cloth_kind, 0) + 1);
        }

        int res = 1;
        for (int cnt : map.values()) {
            res *= (cnt + 1);
        }

        return res - 1;
    }
}