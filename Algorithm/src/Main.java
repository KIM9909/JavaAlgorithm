import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[][] tree;

    static int[] init(int node, int start, int end) {
        if (start == end) {
            tree[node][0] = arr[start];
            tree[node][1] = start;
            return tree[node];
        }

        int mid = (start + end) / 2;
        int[] left = init(node * 2, start, mid);
        int[] right = init(node * 2 + 1, mid + 1, end);

        if (left[0] <= right[0]) {
            tree[node][0] = left[0];
            tree[node][1] = left[1];
        } else {
            tree[node][0] = right[0];
            tree[node][1] = right[1];
        }
        return tree[node];
    }

    static int[] update(int node, int start, int end, int index, int value) {
        if (index < start || index > end) {
            return tree[node];
        }

        if (start == end) {
            tree[node][0] = index;
            tree[node][1] = value;
            return tree[node];
        }

        int mid = (start + end) / 2;
        int[] left = update(node * 2, start, mid, index, value);
        int[] right = update(node * 2 + 1, mid + 1, end, index, value);

        if (left[0] <= right[0]) {
            tree[node][0] = left[0];
            tree[node][1] = left[1];
        } else {
            tree[node][0] = right[0];
            tree[node][1] = right[1];
        }
        return tree[node];
    }

    static int[] query(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return new int[]{Integer.MAX_VALUE, 0};
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int[] leftRes = query(node * 2, start, mid, left, right);
        int[] rightRes = query(node * 2 + 1, mid + 1, end, left, right);

        if (leftRes[0] <= rightRes[0]) {
            return leftRes;
        } else {
            return rightRes;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int treeSize = 4 * N;
        tree = new int[treeSize][2];

        init(1, 1, N);

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());

            if (query == 1) {
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                update(1, 1, N, index, value);
                arr[index] = value;
            } else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                int[] res = query(1, 1, N, left, right);
                sb.append(res[0]).append('\n');
            }
        }
        System.out.println(sb);
    }
}