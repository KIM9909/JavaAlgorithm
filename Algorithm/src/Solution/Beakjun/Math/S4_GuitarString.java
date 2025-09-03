package Solution.Beakjun.Math;
// 1049. Silver4_기타줄

import java.io.*;
import java.util.*;
public class S4_GuitarString {
    static int N, M;
    static int pack, piece;
    static int[] packages, pieces;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        packages = new int[M];
        pieces = new int[M];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            pack = Integer.parseInt(st.nextToken());
            piece = Integer.parseInt(st.nextToken());

            packages[i] = pack;
            pieces[i] = piece;
        }

        Arrays.sort(packages);
        Arrays.sort(pieces);

        int value = 0;

        while (N > 0) {
            if (N > 6) {
                if (packages[0] < pieces[0] * 6) {
                    value += packages[0];
                    N -= 6;
                } else {
                    value += pieces[0] * 6;
                    N -= 6;
                }
            } else {
                int minV = Math.min(packages[0], pieces[0] * N);
                value += minV;
                break;
            }
        }

        System.out.println(value);
    }
}
