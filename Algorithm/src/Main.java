import java.io.*;
import java.util.*;

public class Main {
    static int month, day;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        month = Integer.parseInt(br.readLine());
        day = Integer.parseInt(br.readLine());

        if (month == 2 && day == 18) {
            System.out.println("Special");
        }

        if (month < 2 || (month == 2 && day < 18)) {
            System.out.println("Before");
        }

        if (month > 2 || (month == 2 && day > 18)) {
            System.out.println("After");
        }
    }
}