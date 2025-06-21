// 14438. 수열과 쿼리 17 (세그먼트 트리)
package Solution.Beakjun.Tree;

import java.io.*;
import java.util.*;
public class SequenceAndQuery17 {
    static int N, M;
    static int[] arr;
    static int[][] tree; // [value, index]를 저장

    static int[] init(int node, int start, int end) {
        // 리프 노드인 경우
        if (start == end) {
            tree[node][0] = arr[start]; // 값 저장
            tree[node][1] = start;      // 인덱스 저장
            return tree[node];
        }

        // 구간을 둘로 나누어 재귀적으로 처리
        int mid = (start + end) / 2;
        int[] left = init(node * 2, start, mid);
        int[] right = init(node * 2+1, mid+1, end);

        // 더 작은 값을 가진 노드의 정보를 저장
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
        // 업데이트할 위치가 현재 구간을 벗어난 경우
        if (index < start || end < index) {
            return tree[node];
        }

        if (start == end) {
            tree[node][0] = value;
            tree[node][1] = index;
            return tree[node];
        }

        int mid = (start + end) / 2;
        int[] left = update(node * 2, start, mid, index, value);
        int[] right = update(node * 2 + 1, mid+1, end, index, value);

        if (left[0] <= right[0]) {
            tree[node][0] = left[0];
            tree[node][1] = left[1];
        } else {
            tree[node][0] = right[0];
            tree[node][1] = right[1];
        }
        return tree[node];
    }

    // 구간의 최솟값을 찾는 메서드
    static int[] query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {  // 범위를 벗어난 경우
            return new int[]{Integer.MAX_VALUE, 0};
        }

        if (left <= start && end <= right) {  // 완전히 포함되는 경우
            return tree[node];
        }

        int mid = (start + end) / 2;
        int[] leftResult = query(node*2, start, mid, left, right);
        int[] rightResult = query(node*2+1, mid+1, end, left, right);

        if (leftResult[0] <= rightResult[0]) {
            return leftResult;
        } else {
            return rightResult;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 수열의 크기
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 세그먼트 트리 크기 계산
        int treeSize = 4 * N; // 충분한 트리 크기
        tree = new int[treeSize][2];

        // 세그먼트 트리 초기화
        init(1, 1, N);

        // 쿼리 개수
        M = Integer.parseInt(br.readLine());
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());

            if (query == 1) {   // 업데이트 쿼리
                int idx = Integer.parseInt(st.nextToken());  // 업데이트할 위치
                int val = Integer.parseInt(st.nextToken());  // 새로운 값
                update(1, 1, N, idx, val);  // 세그먼트 트리 업데이트
                arr[idx] = val;
            } else {  // 최솟값의 인덱스 출력 쿼리
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                int[] result = query(1, 1, N, left, right);
                sb.append(result[0]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
