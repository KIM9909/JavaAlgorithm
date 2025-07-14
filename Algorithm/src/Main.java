import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<N; i++) {
                sb.append("*");
            }
            System.out.println(sb.toString());
            N -= 1;
        }
    }
}