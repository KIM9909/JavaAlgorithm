import java.io.*;
import java.util.*;

public class Main {
    static int ascii;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ascii = br.readLine().charAt(0);

        System.out.println(ascii);
    }
}