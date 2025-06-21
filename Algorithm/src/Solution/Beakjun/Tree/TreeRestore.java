package Solution.Beakjun.Tree;
// 6597. 트리 복구

import java.io.*;
import java.util.*;

public class TreeRestore {
    // 전위 순회, 중위 순회, 후위 순회
    static String preOrder, inOrder, postOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line;

        // EOF 까지 입력 받기
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);

            preOrder = st.nextToken();
            inOrder = st.nextToken();
            postOrder = buildPost(preOrder, inOrder);

            System.out.println(postOrder);
        }
    }

    static String buildPost(String pre, String in) {
        // 빈 문자열이면 빈 결과 반환
        if (pre.length() == 0) {
            return "";
        }

        // 전위 순회의 첫 번째가 루트
        char root = pre.charAt(0);

        // 중위 순회에서 루트의 위치를 찾기
        int rootIdx = in.indexOf(root);

        // 좌측 서브트리와 우측 서브트리로 분할
        // ABCDEFG인 경우 (중위 순회 기준)
        String leftInOrder = in.substring(0, rootIdx); // 0번째 부터 root 전까지 (ABC : 좌측 트리)
        String rightInOrder = in.substring(rootIdx + 1); // root + 1 부터 끝까지 (EFG : 우측 트리)

        int leftSize = leftInOrder.length();

        // DBACEGF인 경우 (전위 순회 기준)
        String leftPreOrder = pre.substring(1, 1 + leftSize); // 1번째 부터 1 + 좌측 트리 크기(3) 전까지 (BAC)
        String rightPreOrder = pre.substring(1 + leftSize); // 1 + 좌측 트리 크기(3) 부터 끝까지 (EGF)

        // 재귀로 좌우 서브트리의 후위 순회 구하기
        String leftPostOrder = buildPost(leftPreOrder, leftInOrder);
        String rightPostOrder = buildPost(rightPreOrder, rightInOrder);

        // 후위 순회 : 좌 -> 우 -> 루트
        return leftPostOrder + rightPostOrder + root;
    }
}