package Solution.PrepareA_beakjun.SetAndMap;
// 1269. 대칭과 차집합

import java.util.*;
import java.io.*;
public class SymmetryAndDiffer {
    static int A, B;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<A; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<B; i++) {
            int BNum = Integer.parseInt(st.nextToken());

            if (set.contains(BNum)) {
                set.remove(BNum);
            } else {
                set.add(BNum);
            }
        }

        System.out.println(set.size());
    }
}
