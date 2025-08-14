package Solution.Beakjun.Math;
// 1402. S5_아무래도이문제는A번난이도인것같다

import java.io.*;
import java.util.*;
public class S5_ADifficult {
    static int T, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // 이 문제는 소인수 분해가 핵심이 아니다
            // A가 5, B가 999라도 답은 yes 가 나올 수 밖에 없다
            // A = 1*1*1*1...*5=5, B = 1+1+1+1...+5=999가 가능하기 때문
            System.out.println("yes");
        }
    }
}
