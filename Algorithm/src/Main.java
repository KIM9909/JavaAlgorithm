import java.io.*;
import java.util.*;

public class Main {
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());
        int num = 5;
        int cnt = 0;

        while (L > 0) {
            if (L == 0) {
                break;
            }
            cnt += L/num;
            L %= num;
            num --;
        }

        System.out.println(cnt);
    }
}