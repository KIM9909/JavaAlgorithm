package Solution.Beakjun.Greedy;
// 1138. Silver2_한 줄로 서기

import java.util.*;
import java.io.*;
public class S2_OneLine {
    static int N;
    static int[] line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        line = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = new int[N];

        for (int i=1; i<=N; i++) {
            int left = line[i-1];
            int pos = 0;

            for (int j=0; j<N; j++) {
                if (res[j] == 0) {
                    if (left == pos) {
                        res[j] = i;
                        break;
                    }
                    pos ++;
                }
            }
        }

        for (int i=0; i<N; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
