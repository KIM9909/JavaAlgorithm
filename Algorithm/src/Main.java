import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BigInteger N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = new BigInteger(st.nextToken());
        M = new BigInteger(st.nextToken());

        if (N.equals(M)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

    }
}