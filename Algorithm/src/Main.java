import java.io.*;

public class Main {
    static int total;
    static int nineBooks = 0;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        total = Integer.parseInt(br.readLine());

        for (int i=0; i<9; i++) {
            nineBooks += Integer.parseInt(br.readLine());
        }

        res = total - nineBooks;

        System.out.println(res);
    }
}