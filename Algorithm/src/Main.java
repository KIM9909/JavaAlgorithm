import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder();

            String str = br.readLine();

            String cur = "";
            for (int j=0; j<str.length(); j++) {
                if (!cur.equals(String.valueOf(str.charAt(j)))) {
                    sb.append(str.charAt(j));

                    cur = String.valueOf(str.charAt(j));
                }
            }

            System.out.println(sb.toString());
        }
    }
}