import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String F, A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int cnt = 0;
        ArrayList<String> lst = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            F = st.nextToken();
            lst.add(F);
        }

        A = br.readLine();

        for (String tempLst : lst) {
            if (tempLst.equals(A)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}