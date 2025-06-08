package Solution.PrepareA_beakjun.Tree;
// 2263. 트리의 순회

import java.io.*;
import java.util.*;
public class TreeTraversal_gold1 {
    static int n; // 정점의 개수
    static int in_node, post_node;
    static int[] inOrder;
    static int[] postOrder;
    static int[] pos;
    static StringBuilder preOrder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];
        pos = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            in_node = Integer.parseInt(st.nextToken());
            inOrder[i] = in_node;
            pos[inOrder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            post_node = Integer.parseInt(st.nextToken());
            postOrder[i] = post_node;
        }

        makePreOrder(0, n-1, 0, n-1);

        System.out.println(preOrder.toString());
    }

    static void makePreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int root = postOrder[postEnd];
        preOrder.append(root).append(" ");

        int rootIdx = pos[root];

        // 좌측 서브트리 크기
        int leftSize = rootIdx - inStart;

        // 좌측 서브트리 처리
        makePreOrder(inStart, rootIdx - 1, postStart, postStart + leftSize - 1);

        // 우측 서브트리 처리
        makePreOrder(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}
