package Solution.Programmers.Algo.StackAndQue;
// Lv.2 주식가격

//import java.util.*;
//class StockPrice {
//    public int[] solution(int[] prices) {
//        int[] answer = new int[prices.length];
//
//        for (int i=0; i< prices.length; i++) {
//            int cnt = 0;
//
//            for (int j=i+1; j< prices.length; j++) {
//                cnt ++;
//
//                if (prices[j] < prices[i]) {
//                    break;
//                }
//            }
//
//            answer[i] = cnt;
//        }
//
//        return answer;
//    }
//}

import java.util.*;
class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i< prices.length; i++) {

            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }

        return answer;
    }
}