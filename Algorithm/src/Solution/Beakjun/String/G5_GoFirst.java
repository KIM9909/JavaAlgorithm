package Solution.Beakjun.String;
// 3655. 먼저 가세요

import java.io.*;
import java.util.*;
public class G5_GoFirst {
    static int T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            char[] people = s.toCharArray();

            Map<Character, Integer> peopleCnt = new HashMap<>();
            Map<Character, Integer> lastIdx = new HashMap<>();

            // 각 그룹의 개수와 마지막 인덱스 저장
            for (int i = 0; i < N; i++) {
                char c = people[i];
                peopleCnt.put(c, peopleCnt.getOrDefault(c, 0) + 1);
                lastIdx.put(c, i);
            }

            // 각 그룹을 마지막 인덱스 기준으로 정렬
            List<Character> groups = new ArrayList<>();
            for (char c : peopleCnt.keySet()) {
                groups.add(c);
            }
            groups.sort((a, b) -> Integer.compare(lastIdx.get(a), lastIdx.get(b)));

            int res = 0;
            int currentPos = 0;

            for (char current : groups) {
                int groupCnt = peopleCnt.get(current);
                int lastGroupIdx = currentPos + groupCnt - 1;

                // 기본 절약시간(5) * 이동 횟수 * 기다리는 그룹의 수
                res += 5 * (lastIdx.get(current) - lastGroupIdx) * groupCnt;

                currentPos += groupCnt; // 다음 그룹 시작 위치
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}