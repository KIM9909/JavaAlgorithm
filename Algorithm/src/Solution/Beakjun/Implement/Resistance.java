package Solution.Beakjun.Implement;
// 1076. 저항

import java.util.*;
import java.io.*;
public class Resistance {
    static HashMap<String, String> resist = new HashMap<>();
    static String A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        resist.put("black", "0");
        resist.put("brown", "1");
        resist.put("red", "2");
        resist.put("orange", "3");
        resist.put("yellow", "4");
        resist.put("green", "5");
        resist.put("blue", "6");
        resist.put("violet", "7");
        resist.put("grey", "8");
        resist.put("white", "9");

        A = br.readLine();
        B = br.readLine();
        C = br.readLine();

        String forward = resist.get(A) + resist.get(B);

        long res = Long.parseLong(forward) * (long) Math.pow(10, Long.parseLong(resist.get(C)));

        System.out.println(res);
    }
}
