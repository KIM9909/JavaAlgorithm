package Solution.PrepareA_beakjun.DataStructure;
// 17413. 단어 뒤집기 2
import java.io.*;

public class WordReverse2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        boolean inTag = false;

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if (c == '<') {
                // 태그 안에 있는 단어들
                if (sb.length() > 0) {
                    // 이전에 모인 단어들이 있다면 한 번 뒤집어서 출력
                    System.out.print(sb.reverse());
                    sb = new StringBuilder();
                }
                inTag = true;
                System.out.print(c); // '<' 출력
            }
            else if (c == '>') {
                // 태그가 끝
                inTag = false;
                System.out.print(c); // '>' 출력
            }
            else if (inTag) {
                System.out.print(c); // 태그 안에 있는 단어는 그대로 출력
            }
            else if (c == ' ') {
                System.out.print(sb.reverse()); // 공백을 만나면 이전의 단어들을 뒤집어서 출력
                System.out.print(c); // 공백 출력
                sb = new StringBuilder();
            }
            else {
                // 단어를 계속 넣기
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            System.out.print(sb.reverse()); // 끝 단어 처리
        }
    }
}
