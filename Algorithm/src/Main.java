import java.io.*;
import java.util.*;

public class Main {
    static String N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while (!(line = br.readLine()).equals("0")) {
            N = line;
            int width = 1;
            for (int i=0; i<N.length(); i++) {
                if (N.charAt(i) == '1') {
                    width += 2;
                } else if (N.charAt(i) == '0') {
                    width += 4;
                } else {
                    width += 3;
                }
                width += 1;
            }

            System.out.println(width);
        }
    }
}