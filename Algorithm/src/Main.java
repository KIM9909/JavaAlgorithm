import java.io.*;
import java.util.*;

public class Main {
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        num = Integer.parseInt(br.readLine());

        sb.append((int) (num * 0.78)).append(" ").append((int) (num - num * 0.2 * 0.22));

        System.out.println(sb);
    }
}