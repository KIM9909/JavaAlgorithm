package Solution.PrepareA_beakjun.Tree;
// 1991. 트리 순회

import java.io.*;
import java.util.*;
public class TreeTraversal {
    static int N;
    static String node, leftChild, rightChild;
    static Map<String, String> left;
    static Map<String, String> right;
    static StringBuilder preOrder = new StringBuilder();
    static StringBuilder inOrder = new StringBuilder();
    static StringBuilder postOrder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        left = new HashMap<>();
        right = new HashMap<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            node = st.nextToken();
            leftChild = st.nextToken();
            rightChild = st.nextToken();

            left.put(node, leftChild.equals(".") ? null : leftChild);
            right.put(node, rightChild.equals(".") ? null : rightChild);
        }

        // 항상 A가 루트
        preOrderTraversal("A");
        inOrderTraversal("A");
        postOrderTraversal("A");

        System.out.println(preOrder.toString());
        System.out.println(inOrder.toString());
        System.out.println(postOrder.toString());
    }

    // 전위 순회
    static void preOrderTraversal(String node) {
        if (node == null) {
            return;
        }

        preOrder.append(node);
        preOrderTraversal(left.get(node));
        preOrderTraversal(right.get(node));
    }

    // 중위 순회
    static void inOrderTraversal(String node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(left.get(node));
        inOrder.append(node);
        inOrderTraversal(right.get(node));
    }

    // 후위 순회
    static void postOrderTraversal(String node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(left.get(node));
        postOrderTraversal(right.get(node));
        postOrder.append(node);
    }
}
