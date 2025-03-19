import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long sum = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            sum = sum * (N-i);
        }

        System.out.println(sum);
    }
}