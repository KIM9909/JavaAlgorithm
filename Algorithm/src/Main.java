import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        arr = new int[] {1, 1, 2, 2, 2, 8};

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<arr.length; i++) {
            sb.append(arr[i] - Integer.parseInt(st.nextToken())).append(" ");
        }

        System.out.println(sb.toString());
    }
}