package Solution.Programmers.Algo.Sort;
// Lv.2 가장 큰 수

import java.util.*;
class BiggestNumber {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        String[] numbersStr = new String[numbers.length];

        for (int i=0; i< numbers.length; i++) {
            numbersStr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numbersStr, (a, b) -> (b+a).compareTo(a+b));

        if (numbersStr[0].equals("0")) {
            return "0";
        }

        for (String number : numbersStr) {
            sb.append(number);
        }

        return sb.toString();
    }
}
