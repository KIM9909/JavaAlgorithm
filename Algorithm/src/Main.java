import java.io.*;
import java.util.*;

public class Main {
    static String name;
    static int age, weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            name = st.nextToken();
            age = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            if (name.equals("#")) {
                break;
            }

            if (age > 17 || weight >= 80) {
                System.out.println(name + " Senior");
            } else {
                System.out.println(name + " Junior");
            }
        }
        br.close();
    }
}