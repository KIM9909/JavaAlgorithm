import java.io.*;
import java.util.*;

public class Main {
    static int L, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int people = L * P;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<5; i++) {
            int differ = Integer.parseInt(st.nextToken()) - people;

            sb.append(differ).append(" ");
        }

        System.out.println(sb);
    }
}