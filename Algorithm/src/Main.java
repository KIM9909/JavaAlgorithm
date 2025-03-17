import java.util.*;
import java.io.*;

public class Main {
    static int sum;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<5; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num * num;
        }

        res = sum % 10;

        System.out.println(res);
    }
}