package Solution.Programmers.Algo.Greedy;
// Lv.2 큰 수 만들기

import java.util.*;
public class MakeBigNum {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for (int i=0; i<number.length(); i++) {
            char current = number.charAt(i);

            while (!stack.isEmpty() && cnt < k && stack.peek() < current) {
                stack.pop();
                cnt ++;
            }

            stack.push(current);
        }

        while (cnt < k) {
            stack.pop();
            cnt ++;
        }

        for (char st : stack) {
            sb.append(st);
        }

        return sb.toString();
    }
}
