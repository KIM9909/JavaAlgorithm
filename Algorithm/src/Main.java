import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String num;
    static char[] nums;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = br.readLine();

        nums = new char[N];

        for (int i=0; i<N; i++) {
            nums[i] = num.charAt(i);
        }

        for (char num : nums) {
            sum += Integer.parseInt(String.valueOf(num));
        }

        System.out.println(sum);
    }
}