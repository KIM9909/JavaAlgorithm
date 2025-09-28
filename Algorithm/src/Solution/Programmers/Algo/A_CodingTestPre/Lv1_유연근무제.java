package Solution.Programmers.Algo.A_CodingTestPre;

public class Lv1_유연근무제 {
    static int res = 0;
    public int solution(int[] schedules, int[][] timelogs, int startday) {

        // 요일의 순서 저장
        int[] dayOfWeek = new int[7];

        for (int i = 0; i < 7; i++) {
            dayOfWeek[i] = startday;
            startday++;
            if (startday > 7) {
                startday = 1;
            }
        }

        // 각 직원별로 체크
        for (int i = 0; i < schedules.length; i++) {
            boolean isNotLate = true;

            // 출근 인정 시각 계산 (희망시각 + 10분)
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100;

            minute += 10;
            if (minute >= 60) {
                hour++;
                minute -= 60;
            }

            // 24시가 넘어가는 경우 처리
            if (hour >= 24) {
                hour -= 24;
            }

            int limit = hour * 100 + minute;

            // 7일 각각 체크
            for (int j = 0; j < 7; j++) {
                // 주말(토=6, 일=7)은 체크하지 않음
                if (dayOfWeek[j] == 6 || dayOfWeek[j] == 7) {
                    continue;
                }

                // 평일인 경우 지각 체크
                if (timelogs[i][j] > limit) {
                    isNotLate = false;
                    break;
                }
            }

            if (isNotLate) {
                res++;
            }
        }

        return res;
    }
}
