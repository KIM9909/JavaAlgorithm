import java.io.*;
import java.util.*;

public class Main {
    static int M, X, Y;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());
        arr = new int[4];

        for (int i=1; i<=3; i++) {
            if (i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

        int temp;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            temp = arr[X];
            arr[X] = arr[Y];
            arr[Y] = temp;
        }

        for (int i=0; i<4; i++) {
            if (arr[i] == 1) {
                System.out.println(i);
            }
        }
    }
}