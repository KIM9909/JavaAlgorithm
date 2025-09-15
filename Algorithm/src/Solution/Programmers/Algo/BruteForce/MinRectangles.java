package Solution.Programmers.Algo.BruteForce;
// Lv.1 최소직사각형

//public class MinRectangles {
//    public int solution(int[][] sizes) {
//        // 1. 가장 큰 수 찾기 (세로가 되든 가로가 되든)
//        int maxNum = 0;
//        for (int i=0; i< sizes.length; i++) {
//            int[] size = sizes[i];
//            for (int j=0; j< size.length; j++) {
//                if (size[j] > maxNum) {
//                    maxNum = size[j];
//                }
//            }
//        }
//
//        // 2. 각 명함을 최적으로 회전시키기
//        for (int i=0; i< sizes.length; i++) {
//            int[] size = sizes[i];
//            if (size[0] < size[1]) {
//                int temp = size[0];
//                size[0] = size[1];
//                size[1] = temp;
//            }
//        }
//
//        // 2-1. 회전 후 두 번째 위치의 최댓값 구하기
//        int secondLen = 0;
//        for (int i=0; i< sizes.length; i++) {
//            int[] size = sizes[i];
//            if (size[1] > secondLen) {
//                secondLen = size[1];
//            }
//        }
//
//        // 3. 결과 계산
//        int res = maxNum * secondLen;
//
//        return res;
//    }
//}

public class MinRectangles {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            maxWidth = Math.max(maxWidth, Math.max(size[0], size[1]));
            maxHeight = Math.max(maxHeight, Math.min(size[0], size[1]));
        }

        return maxHeight * maxWidth;
    }
}