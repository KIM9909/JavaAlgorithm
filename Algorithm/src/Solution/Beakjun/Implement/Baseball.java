package Solution.Beakjun.Implement;

import java.util.*;
import java.io.*;

public class Baseball {
    static int N;
    static int[][] arr;
    static int outCnt;
    static int maxScore;
    static boolean[] selected;
    static int[] lineUp; // 타순
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][9];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new boolean[9];
        lineUp = new int[9];
        maxScore = 0;

        selected[3] = true; // 1번 선수는 4번 타자로 고정
        lineUp[3] = 0;

        permutation(1);
        System.out.println(maxScore);
    }

    // 순열 만들기
    static void permutation(int depth) {
        if (depth == 9) {
            playBaseball();
            return;
        }

        for (int i=0; i<9; i++) {
            if (selected[i]) {
                continue; // 이미 선발이 되어있으면 다음으로
            }
            selected[i] = true;
            lineUp[i] = depth;
            permutation(depth + 1);
            selected[i] = false;
        }
    }

    // 야구 게임 진행
    static void playBaseball() {
        int score = 0;
        boolean[] baseIn; // 루에 주자가 있는지 확인
        int startPlayer = 0; // 첫 타자

        for (int i=0; i<N; i++) {
            outCnt = 0;
            baseIn = new boolean[4];

            outer: while (true) {
                for (int j = startPlayer; j < 9; j++) {
                    int playerHit = arr[i][lineUp[j]];

                    switch (playerHit) {
                        case 0: { // 아웃
                            outCnt++;
                            break;
                        }
                        case 1: { // 1루타
                            for (int k = 3; k >= 1; k--) {
                                if (baseIn[k]) { // 해당 루에 주자가 있는경우
                                    if (k == 3) {
                                        score++;
                                        baseIn[k] = false;
                                        continue;
                                    }
                                    baseIn[k] = false;
                                    baseIn[k + 1] = true;
                                }
                            }
                            // 모든 루에 주자가 없을 경우
                            baseIn[1] = true;
                            break;
                        }
                        case 2: { // 2루타
                            for (int k = 3; k >= 1; k--) {
                                if (baseIn[k]) {
                                    if (k == 3 || k == 2) {
                                        score++;
                                        baseIn[k] = false;
                                        continue;
                                    }
                                    baseIn[k] = false;
                                    baseIn[k + 2] = true;
                                }
                            }
                            baseIn[2] = true;
                            break;
                        }
                        case 3: { // 3루타
                            for (int k = 3; k >= 1; k--) {
                                if (baseIn[k]) {
                                    score++;
                                    baseIn[k] = false;
                                }
                            }
                            baseIn[3] = true;
                            break;
                        }
                        case 4: { // 홈런
                            for (int k = 1; k < 4; k++) {
                                if (baseIn[k]) {
                                    score++;
                                    baseIn[k] = false;
                                }
                            }
                            score++;
                            break;
                        }
                    }
                    if (outCnt == 3) {
                        startPlayer = j+1;
                        if (startPlayer == 9) {
                            startPlayer = 0;
                        }
                        break outer; // outer 라벨이 붙은 while 문을 한번에 종료
                    }
                    // 모든 타자가 쳤지만, 아웃이 3개가 되지 않은 경우 첫번째 타자부터 다시
                    startPlayer = 0;
                }
            }
        }
        maxScore = Math.max(maxScore, score);
    }
}
