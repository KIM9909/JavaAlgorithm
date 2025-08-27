import java.io.*;
import java.util.*;

public class Main {
    static String N;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = br.readLine();
        arr = new Integer[N.length()];

        for (int i=0; i<N.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int num : arr) {
            sb.append(num);
        }

        System.out.println(sb.toString());
    }
}