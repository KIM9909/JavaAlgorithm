import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        for (int i=0; i<4; i++) {
            int time = Integer.parseInt(br.readLine());

            sum += time;
        }

        System.out.println(sum / 60);
        System.out.println(sum % 60);
    }
}