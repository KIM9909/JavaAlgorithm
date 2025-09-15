package Solution.Programmers.Algo.BruteForce;
// Lv.1 모의고사

import java.util.*;
class MockTest {
    public int[] solution(int[] answers) {
        // 수포자1은 1 2 3 4 5 반복
        int[] firstLoop = {1, 2, 3, 4, 5};
        int firstScore = 0;
        // 수포자2는 2 1 2 3 2 4 2 5 반복
        int[] secondLoop = {2, 1, 2, 3, 2, 4, 2, 5};
        int secondScore = 0;
        // 수포자3은 3 3 1 1 2 2 4 4 5 5 반복
        int[] thirdLoop = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int thirdScore = 0;

        int index = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        int thirdIndex = 0;
        while (index < answers.length) {
            if (firstIndex >= firstLoop.length) {
                firstIndex = 0;
            }
            if (secondIndex >= secondLoop.length) {
                secondIndex = 0;
            }
            if (thirdIndex >= thirdLoop.length) {
                thirdIndex = 0;
            }

            if (answers[index] == firstLoop[firstIndex]) {
                firstScore ++;
            }
            if (answers[index] == secondLoop[secondIndex]) {
                secondScore ++;
            }
            if (answers[index] == thirdLoop[thirdIndex]) {
                thirdScore ++;
            }


            firstIndex ++;
            secondIndex ++;
            thirdIndex ++;
            index ++;
        }

        Stack<Integer> res = cal(firstScore, secondScore, thirdScore);

        return res.stream().mapToInt(i -> i).toArray();
    }

    static Stack<Integer> cal(int first, int second, int third) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        max = Math.max(first, Math.max(second, third));

        if (first == max) {
            stack.push(1);
        }
        if (second == max) {
            stack.push(2);
        }
        if (third == max) {
            stack.push(3);
        }

        return stack;
    }
}
