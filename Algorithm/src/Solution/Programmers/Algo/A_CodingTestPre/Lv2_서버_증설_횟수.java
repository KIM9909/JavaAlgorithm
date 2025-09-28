package Solution.Programmers.Algo.A_CodingTestPre;

public class Lv2_서버_증설_횟수 {
    static int scaleServerCnt = 0;
    public int solution(int[] players, int m, int k) {

        // 각 시간대에서 운영을 종료하는 서버 수
        int[] endTimes = new int[players.length + k];

        int currentServer = 0;

        for (int i=0; i<24; i++) {
            currentServer -= endTimes[i];

            int needServer = players[i] / m;

            if (currentServer < needServer) {
                int plus = needServer - currentServer;
                scaleServerCnt += plus;
                currentServer += plus;

                int endTime = i+k;
                endTimes[endTime] += plus;
            }
        }

        return scaleServerCnt;
    }
}
