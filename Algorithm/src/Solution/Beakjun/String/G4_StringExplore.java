package Solution.Beakjun.String;
// 9935. Gold_4_문자열 폭발

import java.util.*;
import java.io.*;
public class G4_StringExplore {
    static String firstS, secondS;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        firstS = br.readLine();
        secondS = br.readLine();

        int bombLen = secondS.length();

        for (int i=0; i<firstS.length(); i++) {
            stack.push(firstS.charAt(i));

            if (stack.size() >= bombLen) {
                boolean isBomb = true;

                // 스택의 뒤에서부터 폭발 문자열과 일치하는지 확인
                for (int j=0; j<bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) != secondS.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                // 폭발 문자열이면 폭발 범위만큼 제거
                if (isBomb) {
                    for (int j=0; j<bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char s : stack) {
                sb.append(s);
            }
            System.out.println(sb);
        }
    }
}
