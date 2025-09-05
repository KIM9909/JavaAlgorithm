package Solution.Beakjun.Greedy;
// 29155. Silver3_개발자 지망생 구름이의 취업 뽀개기

import java.io.*;
import java.util.*;
public class S3_GroomGetJob {
    static int N;
    static int[] todo;
    static List<int[]> problems;
    static int totalTime = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        todo = new int[6];

        // 풀어야할 문제 수를 i를 난이도로 해서 저장
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=5; i++) {
            todo[i] = Integer.parseInt(st.nextToken());
        }

        problems = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int difficulty = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            problems.add(new int[] {difficulty, time});
        }

        // 1. 난이도 순으로 정렬
        // 2. 푸는데 소요되는 시간 순으로 정렬
        Collections.sort(problems, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] cnt = new int[6]; // 해당 난이도의 문제를 푼 횟수 저장
        int[] lastTime = new int[6]; // 같은 난이도일때 이전 문제의 소요시간 저장

        for (int[] problem : problems) {
            int difficulty = problem[0];
            int time = problem[1];

            // 해당 난이도에 풀어야 할 문제수가 남았을 경우
            if (cnt[difficulty] < todo[difficulty]) {
                // 문제간의 소요시간 차를 더해줌
                if (cnt[difficulty] > 0) {
                    totalTime += time - lastTime[difficulty];
                }

                // 소요시간 저장
                totalTime += time;
                // 이전 문제 소요시간 업데이트
                lastTime[difficulty] = time;
                // 문제푼 횟수 증가
                cnt[difficulty] ++;

                // 해당 난이도의 문제를 다 풀었을 경우
                if (cnt[difficulty] == todo[difficulty]) {
                    boolean hasNextLv = false;

                    // 다음 난이도가 있는지 체크
                    for (int i=difficulty + 1; i<=5; i++) {
                        if (todo[i] > 0) {
                            hasNextLv = true;
                            break;
                        }
                    }

                    // 다음 난이도가 존재하면 60분 추가
                    if (hasNextLv) {
                        totalTime += 60;
                    }
                }
            }
        }

        System.out.println(totalTime);
    }
}
