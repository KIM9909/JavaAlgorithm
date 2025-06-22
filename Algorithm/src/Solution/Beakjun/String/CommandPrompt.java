package Solution.Beakjun.String;
// 1032. 명령 프롬프트

import java.io.*;
public class CommandPrompt {
    static int N;
    static String compare = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = null;

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String fileName = br.readLine();
            if (compare == null) {
                compare = fileName;
            }
            if (sb == null) {
                sb = new StringBuilder(compare);
            }
            for (int j=0; j<compare.length(); j++) {
                if (fileName.charAt(j) != compare.charAt(j)) {
                    sb.setCharAt(j, '?');
                }
            }
        }

        System.out.println(sb.toString());
    }
}
