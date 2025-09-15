package Solution.Programmers.Algo.BruteForce;
// Lv.2 카펫

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] size = new int[2];

        // 최소 크기
        int x = 3;
        int y = 3;

        int index = 3;
        while (true) {
            if ((x * y == total) && ((x * 2) + ((y - 2) * 2) == brown)) {
                size[0] = x;
                size[1] = y;
                break;
            }

            if (total % index == 0) {
                x = Math.max(total / index, index);
                y = Math.min(total / index, index);

                index ++;
            } else {
                index ++;
            }
        }

        return size;
    }
}
