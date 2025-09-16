import java.io.*;
import java.util.*;

public class Main {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()));
        }
    }
}