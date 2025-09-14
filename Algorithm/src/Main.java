import java.io.*;
import java.util.*;

public class Main {
    static String id;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        id = br.readLine();

        System.out.println(":fan::fan::fan:");
        System.out.println(":fan::" + id + "::fan:");
        System.out.println(":fan::fan::fan:");
    }
}