package Solution.Programmers.Algo.A_CodingTestPre;

public class Lv2_퍼즐_게임_챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {

        int maxDiff = Integer.MIN_VALUE;
        for (int diff : diffs) {
            if (maxDiff < diff) {
                maxDiff = diff;
            }
        }

        int start = 1;
        int end = maxDiff;

        while (start < end) {
            int mid = (start + end) / 2;

            if (calTime(diffs, times, mid) > limit) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    static long calTime(int[] diffs, int[] times, int level) {
        // diff <= level : time_cur
        // diff > level : (time_cur + time_prev) * (diff - level) + time_cur
        long totalTime = 0;

        for (int i=0; i<diffs.length; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                int failCnt = diffs[i] - level;
                int timePrev = (i == 0) ? 0 : times[i-1];
                totalTime += (times[i] + timePrev) * failCnt + times[i];
            }
        }

        return totalTime;
    }
}
