package Solution.Beakjun.String;
// 11656. Silver_4_접미사 배열

import java.util.*;
import java.io.*;
public class S4_SuffixArray {
    static String S;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        S = br.readLine();
        arr = new String[S.length()];

        for (int i=0; i<S.length(); i++) {
            sb = new StringBuilder();
            for (int j=i; j<S.length(); j++) {
                sb.append(S.charAt(j));
            }
            arr[i] = sb.toString();
        }

        Arrays.sort(arr, (a, b) -> {
            return a.compareTo(b);
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
