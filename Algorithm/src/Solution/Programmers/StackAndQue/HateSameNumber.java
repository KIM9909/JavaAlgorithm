package Solution.Programmers.StackAndQue;
// Lv.1 같은 숫자는 싫어

import java.util.*;
public class HateSameNumber {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            // 스택이 비어있거나, 스택의 마지막 원소와 다르면 추가
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        // 배열로 변환
        int[] stackArr = stack.stream().mapToInt(i -> i).toArray();

        return stackArr;
    }
}
