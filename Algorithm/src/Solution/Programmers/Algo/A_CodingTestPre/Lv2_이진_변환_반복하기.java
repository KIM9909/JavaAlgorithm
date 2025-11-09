package Solution.Programmers.Algo.A_CodingTestPre;

import java.util.*;
public class Lv2_이진_변환_반복하기 {
    public int[] solution(String s) {

        int binaryCnt = 0;
        int removeCnt = 0;

        while (!s.equals("1")) {
            removeCnt += (int)s.chars().filter(c -> c == '0').count();

            s = s.replace("0","");

            binaryCnt ++;

            s = Integer.toBinaryString(s.length());
        }

        return new int[] {binaryCnt, removeCnt};
    }
}
