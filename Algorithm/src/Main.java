import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int YCost, MCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        YCost = 0;
        MCost = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int callTime = Integer.parseInt(st.nextToken());

            if (callTime < 30) {
                YCost += 10;
            } else if (callTime >= 30 && callTime % 30 >= 0) {
                YCost += (callTime / 30) * 10 + 10;
            }

            if (callTime < 60) {
                MCost += 15;
            } else if (callTime >= 60 && callTime % 60 >= 0) {
                MCost += (callTime / 60) * 15 + 15;
            }
        }

        if (MCost < YCost) {
            System.out.println("M " + MCost);
        } else if (MCost == YCost) {
            System.out.println("Y " + "M " + MCost);
        } else {
            System.out.println("Y " + YCost);
        }
    }
}