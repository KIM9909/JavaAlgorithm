package Solution.Beakjun.String;
// 1181. 단어 정렬

import java.io.*;
import java.util.*;
public class S5_WordArray {
    static int N;
    static List<String> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            if (arr.contains(s)) {
                continue;
            } else {
                arr.add(s);
            }
        }

        Collections.sort(arr, (a,b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
