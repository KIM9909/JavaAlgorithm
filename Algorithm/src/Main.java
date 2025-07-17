import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int start, end, ball;
    static int[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = new int[N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            ball = Integer.parseInt(st.nextToken());

            for (int j=start; j<=end; j++) {
                res[j] = ball;
            }
        }

        for (int i=1; i<=N; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb);
    }
}