package Solution.Programmers.Algo.A_CodingTestPre;

public class Lv2_JadenCase_문자열_만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;  // 단어의 첫 글자인지 체크

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                isFirst = true;  // 다음은 새 단어의 첫 글자
            } else {
                sb.append(isFirst ? Character.toUpperCase(c) : Character.toLowerCase(c));
                isFirst = false;
            }
        }

        return sb.toString();
    }
}
