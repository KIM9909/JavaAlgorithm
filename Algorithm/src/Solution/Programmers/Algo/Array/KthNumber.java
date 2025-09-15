package Solution.Programmers.Algo.Array;
// Lv.1 K 번째수

import java.util.*;
class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int start = command[0];
            int end = command[1];
            int pick = command[2];

            int[] sliceArr = new int[end - start + 1];
            int idx = 0;
            for (int j=start-1; j<end; j++) {
                sliceArr[idx++] = array[j];
            }

            Arrays.sort(sliceArr);

            answer[i] = sliceArr[pick - 1];
        }

        return answer;
    }
}
