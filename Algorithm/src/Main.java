import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int x1,y1,x2,y2;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[101][101];

        for (int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int x=x1; x<x2; x++) {
                for (int y=y1; y<y2; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        for (int i=1; i<arr.length; i++) {
            for (int j=1; j<arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    cnt ++;
                }
            }
        }

        System.out.println(cnt);
    }
}