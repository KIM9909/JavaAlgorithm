package Solution.Programmers.Algo.StackAndQue;
// Lv.2 올바른 괄호

//class CorrectParentheses {
//    boolean solution(String s) {
//        int cnt = 0;
//
//        for (int i=0; i<s.length(); i++) {
//            if (cnt < 0) {
//                return false;
//            }
//            if (s.charAt(i) == '(') {
//                cnt ++;
//            } else {
//                cnt --;
//            }
//        }
//
//        if (cnt == 0) {
//            return true;
//        }
//        return false;
//    }
//}

import java.util.*;
class CorrectParentheses {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(1);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}