package Solution.Beakjun.Math;
// 1568. 새

import java.io.*;
public class Bird {
    static int N;
    static int time = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int index = 1;
        while (N > 0) {
            if (N - index >= 0) {
                N -= index;
                time ++;
                index ++;
            } else {
                index = 1;
            }
        }

        System.out.println(time);
    }
}
