import java.io.*;
import java.util.*;
public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            String line = br.readLine();

            String[] words = line.split(" ");

            for (String word : words) {
                if (word.length() == 1) {
                    sb.append(word).append(" ");
                } else {
                    StringBuilder str = new StringBuilder();
                    for (int i=word.length()-1; i>=0; i--) {
                        str.append(word.charAt(i));
                    }

                    sb.append(str).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}