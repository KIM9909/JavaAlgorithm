import java.io.*;
import java.util.*;

public class Main {
    static int R1, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R1 = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        System.out.println(S * 2 - R1);
    }
}