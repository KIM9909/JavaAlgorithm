import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] boxSize, bookSize;
    static int waste = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boxSize = new int[N];
        bookSize = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            boxSize[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            bookSize[i] = Integer.parseInt(st.nextToken());
        }

        int boxIndex = 0;
        int bookIndex = 0;
        while (boxIndex < N && bookIndex < M) {
            if (boxSize[boxIndex] - bookSize[bookIndex] >= 0) {
                boxSize[boxIndex] -= bookSize[bookIndex];
                bookIndex ++;
            } else {
                boxIndex ++;
            }
        }

        for (int i=0; i<N; i++) {
            waste += boxSize[i];
        }

        System.out.println(waste);
    }
}