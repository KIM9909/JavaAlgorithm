import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String strN = String.valueOf(N);

        do {
            if (strN.length() == 1) {
                strN = "0" + strN;
            }

            int sum = Integer.parseInt(String.valueOf(strN.charAt(0))) + Integer.parseInt(String.valueOf(strN.charAt(1)));
            int last = Integer.parseInt(String.valueOf(strN.charAt(1)));

            strN = String.valueOf(last) + (String.valueOf(sum).length() == 1 ? String.valueOf(sum) : String.valueOf(String.valueOf(sum).charAt(1)));
            cnt ++;
        } while (Integer.parseInt(strN) != N);

        System.out.println(cnt);
    }
}