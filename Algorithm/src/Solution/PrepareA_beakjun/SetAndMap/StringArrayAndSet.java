package Solution.PrepareA_beakjun.SetAndMap;
// 14425. 문자열 집합

import java.io.*;
import java.util.*;
public class StringArrayAndSet {
    static int N, M;
    static String setString;
    static String injection;
    static List<String> setS;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        setS = new ArrayList<>();

        for (int i=0; i<N; i++) {
            setString = br.readLine();

            setS.add(setString);
        }

        for (int i=0; i<M; i++) {
            injection = br.readLine();

            if (setS.contains(injection)) {
                res ++;
            }
        }

        System.out.println(res);
    }
}
