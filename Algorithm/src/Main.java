import java.io.*;
import java.util.*;

public class Main {
    static int info, math, science, english;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxScore = Integer.MIN_VALUE;
        int sum = 0;
        StringTokenizer st;

        for (int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            info = Integer.parseInt(st.nextToken());
            math = Integer.parseInt(st.nextToken());
            science = Integer.parseInt(st.nextToken());
            english = Integer.parseInt(st.nextToken());
            sum += info;
            sum += math;
            sum += science;
            sum += english;

            maxScore = Math.max(maxScore, sum);

            sum = 0;
        }

        System.out.println(maxScore);
    }
}