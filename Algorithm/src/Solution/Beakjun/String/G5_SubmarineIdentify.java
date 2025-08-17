package Solution.Beakjun.String;
// 2671. Gold5_잠수함식별

import java.io.*;
public class G5_SubmarineIdentify {
    static String s;
    static int pos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // (100~1~|01)~
        // 100~1~ 혹은 01로 이루어진 것이면 SUBMARINE 아니면 NOISE
        s = br.readLine();
        pos = 0;

        if (parse() && pos == s.length()) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }
    }

    static boolean parse() {
        boolean found = false;

        while (pos < s.length()) {
            if (parse100() || parse01()) {
                found = true;
            } else {
                break;
            }
        }

        return  found;
    }

    // 100~1~ 패턴 확인
    static boolean parse100() {
        int start = pos;

        // 100 확인
        if (pos + 2 >= s.length() || !s.substring(pos, pos + 3).equals("100")) {
            return false;
        }
        pos += 3;

        // 0이 0개 이상
        while (pos < s.length() && s.charAt(pos) == '0') {
            pos++;
        }

        // 1이 하나 이상
        if (pos >= s.length() || s.charAt(pos) != '1') {
            pos = start;
            return false;
        }

        pos++; // 최소 1개는 무조건 소비
        while (pos < s.length() && s.charAt(pos) == '1') {
            // 뒤에 00이 오는지 확인(100) -> 다음 100~1~ 패턴의 시작일 수 있음
            if (pos + 2 < s.length() && s.charAt(pos + 1) == '0' && s.charAt(pos + 2) == '0') {
                break;
            }
            pos++;
        }

        return true;
    };

    // 01 패턴 확인
    static boolean parse01() {
        if (pos + 1 >= s.length() || !s.substring(pos, pos+2).equals("01")) {
            return  false;
        }

        pos += 2;
        return true;
    };
}

//import java.io.*;
//
//public class G5_SubmarineIdentify {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//
//        // (100+1+|01)+
//        String pattern = "^(100+1+|01)+$";
//
//        if (s.matches(pattern)) {
//            System.out.println("SUBMARINE");
//        } else {
//            System.out.println("NOISE");
//        }
//    }
//}