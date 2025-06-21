package Solution.Beakjun.SetAndMap;
// 1764. 듣보잡

import java.io.*;
import java.util.*;
public class UnHeardOf {
    static int N, M;
    static Set<String> noHeard;
    static String noSeen;
    static Set<String> noHeardSeen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        noHeard = new HashSet<>();
        noHeardSeen = new HashSet<>();

        for (int i=0; i<N; i++) {
            noHeard.add(br.readLine());
        }

        for (int i=0; i<M; i++) {
            noSeen = br.readLine();

            if (noHeard.contains(noSeen)) {
                noHeardSeen.add(noSeen);
            }
        }

        List<String> arr = new ArrayList<>(noHeardSeen);

        Collections.sort(arr);

        System.out.println(noHeardSeen.size());

        for (String no : arr) {
            System.out.println(no);
        }
    }
}
