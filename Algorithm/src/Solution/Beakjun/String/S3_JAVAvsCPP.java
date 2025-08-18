package Solution.Beakjun.String;
// 3613. Silver3_Java vs C++

import java.io.*;
public class S3_JAVAvsCPP {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = br.readLine();

        if (!check(s)) {
            System.out.println("Error!");
            return;
        }

        // C++ 입력인 경우
        if (s.contains("_")) {
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '_') {
                    if (i+1 < s.length()) {
                        sb.append(Character.toUpperCase(s.charAt(i+1)));
                        i++;
                    }
                } else {
                    sb.append(s.charAt(i));
                }
            }
        } else { // JAVA 입력인 경우
            for (int i=0; i<s.length(); i++) {
                if (Character.isUpperCase(s.charAt(i))) {
                    sb.append("_").append(Character.toLowerCase(s.charAt(i)));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
        System.out.println(sb.toString());
    }

    static boolean check(String s) {
        boolean isJava = false;
        boolean isCPP = false;

        if (s.contains("_")) {
            isCPP = true;
        }

        for (int i=0; i<s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                isJava = true;
            }

            if (s.charAt(i) == ' ') {
                return false;
            }

            if (!Character.isLetter(s.charAt(i)) && s.charAt(i) != '_') {
                return false;
            }
        }

        if ((isCPP && isJava) || s.contains("__") || s.isEmpty() ||
                Character.isUpperCase(s.charAt(0)) ||
                s.charAt(0) == '_' || s.charAt(s.length()-1) == '_') {
            return false;
        } else {
            return true;
        }
    }
}
