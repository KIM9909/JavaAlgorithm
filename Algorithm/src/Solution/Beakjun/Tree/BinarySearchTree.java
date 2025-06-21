package Solution.Beakjun.Tree;
// 5639. 이진 검색 트리

import java.io.*;
import java.util.*;
public class BinarySearchTree {
    static ArrayList<Integer> preOrder;
    static int node;
    static StringBuilder postOrder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        preOrder = new ArrayList<>();

        while ((line = br.readLine()) != null) {

            if (!line.isEmpty()) {
                node = Integer.parseInt(line);
                preOrder.add(node);
            }
        }

        buildPostOrder(0, preOrder.size() - 1);

        System.out.println(postOrder);
    }

    static void buildPostOrder (int start, int end) {
        if (start > end) {
            return;
        }

        int root = preOrder.get(start);

        int rightStart = start + 1;
        while (rightStart <= end && preOrder.get(rightStart) < root) {
            rightStart ++;
        }

        buildPostOrder(start + 1, rightStart - 1);
        buildPostOrder(rightStart, end);
        postOrder.append(root).append('\n');
    }
}
