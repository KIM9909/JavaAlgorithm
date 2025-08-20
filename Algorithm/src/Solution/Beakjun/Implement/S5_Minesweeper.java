package Solution.Beakjun.Implement;
// 1996. 지뢰 찾기

import java.util.*;
import java.io.*;
public class S5_Minesweeper {
    static int N;
    static char[][] arr;
    static int[][] resArr;
    static int[] dr = {1,1,0,-1,-1,-1,0,1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        resArr = new int[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<line.length(); j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (Character.isDigit(arr[i][j])) {
                    resArr[i][j] = -1;

                    for (int k=0; k<8; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (0 <= nr && nr < N && 0 <= nc && nc < N && resArr[nr][nc] != -1) {
                            resArr[nr][nc] += Integer.parseInt(String.valueOf(arr[i][j]));
                        }
                    }
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (resArr[i][j] == -1) {
                    sb.append("*");
                } else if (resArr[i][j] >= 10) {
                    sb.append("M");
                } else {
                    sb.append(resArr[i][j]);
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
