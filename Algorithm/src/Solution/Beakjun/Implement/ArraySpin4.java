package Solution.Beakjun.Implement;

import java.util.*;
import java.io.*;

public class ArraySpin4 {
    static int N, M, K;
    static int[][] arr;
    static int min_sum;
    static ArrayList<int[]> lst;
    static boolean[] visited;
    static int[] order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        min_sum = 999999;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        lst = new ArrayList<>();

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            lst.add(new int[] {r,c,s});
        }

        visited = new boolean[K];
        order = new int[K];

        permutation(0);
        System.out.println(min_sum);
    }

    // 순열 조합 만드는 함수
    static void permutation(int cnt) {
        if (cnt == K) {
            executeRotation();
            return;
        }
        for (int i=0; i<K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[cnt] = i; // order 에 꺼내올 값의 위치 저장
                permutation(cnt + 1);
                visited[i] = false; // 백트래킹으로 겹치지 않는 조합 생성
            }
        }
    }

    // 만든 조합을 순서로 실행시키는 함수
    static void executeRotation() {

        // 회전시킬 임시 배열 생성
        int[][] temp_arr = new int[N][M];
        for (int i=0; i<N; i++) {
            temp_arr[i] = arr[i].clone();
        }

        for (int i=0; i<K; i++) {
            // lst 에 담겨있는 좌표값을 정해진 순서로 뽑음
            int[] op = lst.get(order[i]);
            rotate(temp_arr, op[0], op[1], op[2]);
        }

        // 각 행을 더한 값 계산 및 비교
        for (int i=0; i<N; i++) {
            int sum = 0;
            for (int j=0; j<M; j++) {
                sum += temp_arr[i][j];
            }
            if (min_sum > sum) {
                min_sum = sum;
            }
        }
    }

    // 회전시키는 함수
    static void rotate(int[][] temp_arr, int r, int c, int s) {

        // s값 기준으로 나눠지기 때문에 s크기만큼 순회
        for (int i=1; i<=s; i++) {
            int x1 = r - i;
            int y1 = c - i;
            int x2 = r + i;
            int y2 = c + i;

            int temp = temp_arr[x1][y1];

            // 왼쪽 면 : 아래에서 위로
            for (int j=x1; j<x2; j++) {
                temp_arr[j][y1] = temp_arr[j+1][y1];
            }

            // 아래쪽 면 : 오른쪽에서 왼쪽으로
            for (int j=y1; j<y2; j++) {
                temp_arr[x2][j] = temp_arr[x2][j+1];
            }

            // 오른쪽 면 : 위에서 아래로
            for (int j=x2; j>x1; j--) {
                temp_arr[j][y2] = temp_arr[j-1][y2];
            }

            // 위쪽 면 : 왼쪽에서 오른쪽으로
            for (int j=y2; j>y1; j--) {
                temp_arr[x1][j] = temp_arr[x1][j-1];
            }

            // 처음 시작 위치를 회전 후의 위치로 이동
            temp_arr[x1][y1+1] = temp;
        }
    }
}
