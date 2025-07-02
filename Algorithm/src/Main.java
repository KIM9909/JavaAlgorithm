import java.io.*;
import java.util.*;

public class Main {
    static String hwan;
    static String doctor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        hwan = br.readLine();
        doctor = br.readLine();

        if (hwan.length() < doctor.length()) {
            System.out.println("no");
        } else {
            System.out.println("go");
        }
    }
}