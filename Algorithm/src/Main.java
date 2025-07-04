import java.io.*;
import java.util.*;

public class Main {
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();

        String res = "";

        for (int i=0; i<word.length(); i++) {
            char w = word.charAt(i);

            if (Character.isUpperCase(w)) {
                res += Character.toLowerCase(w);
            } else {
                res += Character.toUpperCase(w);
            }
        }

        System.out.println(res);
    }
}