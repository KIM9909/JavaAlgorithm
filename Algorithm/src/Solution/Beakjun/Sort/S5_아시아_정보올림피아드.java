package Solution.Beakjun.Sort;

import java.io.*;
import java.util.*;
public class S5_아시아_정보올림피아드 {
    static int N;
    static int countryNum, studentNum, score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        List<int[]> students = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            countryNum = Integer.parseInt(st.nextToken());
            studentNum = Integer.parseInt(st.nextToken());
            score = Integer.parseInt(st.nextToken());

            students.add(new int[] {countryNum, studentNum, score});
        }

        Collections.sort(students, (a, b) -> {
            return b[2] - a[2];
        });

        int[] countryMedals = new int[N+1];

        int medalCnt = 0;
        int idx = 0;

        while (medalCnt < 3 && idx < N) {
            int country = students.get(idx)[0];
            int student = students.get(idx)[1];

            if (countryMedals[country] < 2) {
                sb.append(country).append(" ").append(student).append("\n");
                countryMedals[country] ++;
                medalCnt ++;
            }

            idx ++;
        }

        System.out.println(sb);
    }
}
