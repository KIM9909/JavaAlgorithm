package Solution.Beakjun.Implement;

import java.util.*;
import java.io.*;
public class S5_기상캐스터 {
    static int H, W;
    static char[][] arr;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new char[H][W];
        visited = new int[H][W];

        for (int i=0; i<H; i++) {
            String line = br.readLine();
            for (int j=0; j<W; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                visited[i][j] = -1;
                if (arr[i][j] == 'c') {
                    visited[i][j] = 0;
                }
            }
        }

        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                if (arr[i][j] == 'c') {
                    int time = 1;
                    for (int k=j+1; k<W; k++) {
                        if (arr[i][k] == 'c') {
                            break;
                        }

                        if (visited[i][k] == -1) {
                            visited[i][k] = time;
                        }
                        time ++;
                    }
                }
            }
        }

        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                sb.append(visited[i][j]);
                if (j < W-1) {
                    sb.append(" ");
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
