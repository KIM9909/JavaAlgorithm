package Solution.Programmers.Algo.Heap;
// Lv.3 이중우선순위큐

//import java.util.*;
//import java.io.*;
//class DoublePQ {
//    public int[] solution(String[] operations) {
//        PriorityQueue<Integer> pqMin = new PriorityQueue<>(Comparator.naturalOrder());
//        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
//        // 행동 저장
//        String[] command = new String[operations.length];
//        // 숫자 저장
//        int[] number = new int[operations.length];
//        // return 값 저장
//        int[] res = new int[2];
//
//        // 초기화
//        for (int i=0; i<2; i++) {
//            res[i] = 0;
//        }
//
//        for (int i=0; i< operations.length; i++) {
//            String comm = String.valueOf(operations[i].charAt(0));
//            command[i] = comm;
//
//            int num = Integer.parseInt(operations[i].substring(2));
//            number[i] = num;
//        }
//
//        for (int i=0; i<operations.length; i++) {
//            // 삽입 (I)
//            if (command[i].equals("I")) {
//                pqMin.offer(number[i]);
//                pqMax.offer(number[i]);
//            } else { // 삭제 (D)
//                if (!pqMin.isEmpty() && !pqMax.isEmpty() && number[i] == 1) {
//                    int max = pqMax.poll();
//                    pqMin.remove(max);
//                } else if (!pqMax.isEmpty() && !pqMin.isEmpty() && number[i] == -1) {
//                    int min = pqMin.poll();
//                    pqMax.remove(min);
//                }
//            }
//        }
//
//        if (!pqMin.isEmpty() && !pqMax.isEmpty()) {
//            res[0] = pqMax.poll();
//            res[1] = pqMin.poll();
//        } else {
//            return res;
//        }
//
//        return res;
//    }
//}



import java.util.*;
class DoublePQ {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        int[] res = new int[2];

        for (int i=0; i<res.length; i++) {
            res[i] = 0;
        }

        for (String operation : operations) {
            if (operation.startsWith("I ")) {
                pqMin.offer(Integer.parseInt(operation.substring(2)));
                pqMax.offer(Integer.parseInt(operation.substring(2)));
            } else {
                if (operation.equals("D 1") && !pqMin.isEmpty() && !pqMax.isEmpty()) {
                    int max = pqMax.poll();
                    pqMin.remove(max);
                } else if (operation.equals("D -1") && !pqMin.isEmpty() && !pqMax.isEmpty()) {
                    int min = pqMin.poll();
                    pqMax.remove(min);
                }
            }
        }

        if (!pqMin.isEmpty() && !pqMax.isEmpty()) {
            res[0] = pqMax.poll();
            res[1] = pqMin.poll();
        } else {
            return res;
        }

        return res;
    }
}