package Solution.Beakjun.Implement;

import java.util.*;
import java.io.*;
public class ConveyorBeltRobot {
    static int N;
    static int K;
    static int[] conveyor;
    static int[] is_robot;
    static int final_cnt;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        conveyor = new int[2*N];
        is_robot = new int[2*N];
        final_cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<2*N; i++) {
            conveyor[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            // 컨베이어 벨트 내구성 확인
            cnt = 0;
            for (int i=0; i<2*N; i++) {
                if (conveyor[i] == 0) {
                    cnt++;
                    if (cnt >= K) {
                        System.out.println(final_cnt);
                        return;
                    }
                }
            }
            final_cnt ++;

            // 컨베이어 벨트 회전
            int temp_conveyor = conveyor[2*N-1];
            int temp_is_robot = is_robot[2*N-1];

            for (int i=2*N-1; i>0; i--) {
                conveyor[i] = conveyor[i-1];
                is_robot[i] = is_robot[i-1];
            }

            conveyor[0] = temp_conveyor;
            is_robot[0] = temp_is_robot;

            is_robot[N-1] = 0; // 내리는 위치에서는 로봇 삭제

            // 로봇 이동
            for (int i=N-2; i>=0; i--) {
                if (is_robot[i] == 1 && is_robot[i+1] != 1 && conveyor[i+1] > 0) {
                    is_robot[i+1] = is_robot[i];
                    is_robot[i] = 0;
                    conveyor[i+1] --;
                    if (is_robot[N-1] == 1) {
                        is_robot[N-1] = 0; // 내리는 위치에서 로봇 삭제
                    }
                }
            }

            // 로봇 올리기
            if (conveyor[0] > 0) {
                is_robot[0] = 1;
                conveyor[0] --;
            }
        }
    }
}
