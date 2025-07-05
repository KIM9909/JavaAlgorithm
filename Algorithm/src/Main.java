import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            sb = new StringBuilder();
            word = br.readLine();

            sb.append(word.charAt(0)).append(word.charAt(word.length() - 1));

            System.out.println(sb.toString());
        }
    }
}