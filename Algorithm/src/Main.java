import java.io.*;
import java.util.Objects;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!Objects.equals(line = br.readLine(), "#")) {
            String english = line;

            for (int i=0; i<english.length(); i++) {
                if (english.charAt(i) == 'a' || english.charAt(i) == 'e' || english.charAt(i) == 'i' || english.charAt(i) == 'o' || english.charAt(i) == 'u' ||
                english.charAt(i) == 'A' || english.charAt(i) == 'E' || english.charAt(i) == 'I' || english.charAt(i) == 'O' || english.charAt(i) == 'U') {
                    cnt ++;
                }
            }

            System.out.println(cnt);

            cnt = 0;
        }
    }
}