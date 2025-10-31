package Solution.Beakjun.Implement;

import java.io.*;
import java.util.*;
public class S5_금메달_은메달_동메달은_누가 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> firstRace = new ArrayList<>();
        firstRace.add(0);

        for (int i = 1; i <= N; i++) {
            int next = Integer.parseInt(br.readLine());

            if (next >= firstRace.size()) {
                firstRace.add(i);
            } else if (firstRace.get(next) != 0) {
                firstRace.add(next, i);
            } else {
                firstRace.add(next, i);
            }
        }

        int[] nextPart = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            nextPart[i] = firstRace.get(M + 1 - i);  // M등 ~ 1등 순서
        }

        // 두 번째 경기는 M등부터 출발
        List<Integer> secondRace = new ArrayList<>();
        secondRace.add(0);

        // 두 번째 경주
        for (int i = 1; i <= M; i++) {
            int next = Integer.parseInt(br.readLine());
            int currentPlayer = nextPart[i];  // 현재 출발하는 선수 번호

            if (next >= secondRace.size()) {
                secondRace.add(currentPlayer);
            } else if (secondRace.get(next) != 0) {
                secondRace.add(next, currentPlayer);
            } else {
                secondRace.add(next, currentPlayer);
            }
        }

        for (int i=1; i<=3; i++) {
            sb.append(secondRace.get(i)).append("\n");
        }

        System.out.print(sb);
    }
}