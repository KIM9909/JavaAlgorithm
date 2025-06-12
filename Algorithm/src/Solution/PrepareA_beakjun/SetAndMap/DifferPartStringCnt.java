package Solution.PrepareA_beakjun.SetAndMap;
// 11478. 서로 다른 부분 문자열의 개수

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DifferPartStringCnt {
    static String S;
    static Set<String> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        arr = new HashSet<>();

        arr.add(S);

        for (int i=0; i<S.length(); i++) {
            for (int j=i+1; j<=S.length(); j++) {
                arr.add(S.substring(i, j));
            }
        }

        System.out.println(arr.size());
    }
}
