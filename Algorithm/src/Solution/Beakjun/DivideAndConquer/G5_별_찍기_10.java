package Solution.Beakjun.DivideAndConquer;

import java.io.*;
public class G5_별_찍기_10 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (isStar(i, j)) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean isStar(int x, int y) {
        if (x == 0 && y == 0) {
            return true;
        }

        if (x%3 == 1 && y%3 == 1) {
            return false;
        }

        return isStar(x/3, y/3);
    }
}
