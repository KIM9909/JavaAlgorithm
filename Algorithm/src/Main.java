import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    int lcm1 = lcm(arr[i], arr[j]);
                    int lcm2 = lcm(lcm1, arr[k]);

                    result = Math.min(result, lcm2);
                }
            }
        }

        System.out.println(result);
    }

    // 최대공약수
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수
    static int lcm(int a, int b) {

        return (a * b) / gcd(a, b);
    }
}