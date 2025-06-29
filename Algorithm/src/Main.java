import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int maxNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        arr = new int[10][10];
        maxNum = Integer.MIN_VALUE;

        for (int i=1; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<10; j++) {
                int number = Integer.parseInt(st.nextToken());
                arr[i][j] = number;
            }
        }

        for (int i=1; i<10; i++) {
            for (int j=1; j<10; j++) {
                if (arr[i][j] > maxNum) {
                    maxNum = arr[i][j];
                }
            }
        }

        System.out.println(maxNum);

        outer: for (int i=1; i<10; i++) {
            for (int j=1; j<10; j++) {
                if (maxNum == arr[i][j]) {
                   sb.append(i).append(" ").append(j);
                   break outer;
                }
            }
        }

        System.out.println(sb);
    }
}