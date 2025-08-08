package Solution.Beakjun.String;
// 11536. Silver5_줄 세우기

import java.io.*;
public class S5_LineUp {
    static int N;
    static String[] names;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        names = new String[N];

        for (int i=0; i<N; i++) {
            names[i] = br.readLine();
        }

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i=1; i<N; i++) {
            int compare = names[i-1].compareTo(names[i]);

            if (compare > 0) {
                isIncreasing = false;
            } else {
                isDecreasing = false;
            }
        }

        if (isIncreasing) {
            System.out.println("INCREASING");
        } else if (isDecreasing) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
    }
}
