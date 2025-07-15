import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr.add(a);
        arr.add(b);
        arr.add(c);

        Collections.sort(arr);

        for (int num : arr) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}