package Solution.Programmers.Algo.Heap;
// Lv.2 더 맵게

import java.util.*;
class MoreSpicy {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int sco : scoville) {
            heap.offer(sco);
        }

        int mixCnt = 0;

        while (heap.peek() < K && heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();

            int blender = first + (second * 2);

            heap.offer(blender);
            mixCnt ++;
        }

        if (heap.peek() >= K) {
            return mixCnt;
        } else {
            return -1;
        }
    }
}
