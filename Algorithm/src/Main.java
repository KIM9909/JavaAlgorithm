import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] front, back;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        front = new int[N];
        back = new int[N];

        int frontO = 0;
        int backO = 0;
        int frontX = 0;
        int backX = 0;

        for (int i=0; i<M; i++) {
            front[i] = 1;
        }

        for (int i=0; i<K; i++) {
            back[i] = 1;
        }

        for (int num : front) {
            if (num == 1) {
                frontO ++;
            } else {
                frontX ++;
            }
        }

        for (int num : back) {
            if (num == 1) {
                backO ++;
            } else {
                backX ++;
            }
        }
        int cntO = Math.min(frontO, backO);
        int cntX = Math.min(frontX, backX);

        System.out.println(cntO + cntX);
    }
}