package Solution.Programmers.Algo.Sort;

import java.util.*;
public class Lv_2_최댓값과_최솟값 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");

        List<Integer> lst = new ArrayList<>();

        for (String a : arr) {
            lst.add(Integer.parseInt(a));
        }

        Collections.sort(lst);
        sb.append(lst.get(0)).append(" ").append(lst.get(lst.size()-1));

        return sb.toString();
    }
}
