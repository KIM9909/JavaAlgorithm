package Solution.Beakjun.String;

import java.io.*;
import java.util.*;
public class S5_생일 {
    static int n;
    static String name;
    static int dd, mm, yyyy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        List<int[]> students = new ArrayList<>();
        String[] names = new String[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            dd = Integer.parseInt(st.nextToken());
            mm = Integer.parseInt(st.nextToken());
            yyyy = Integer.parseInt(st.nextToken());

            names[i] = name;
            students.add(new int[] {yyyy, mm, dd, i});
        }

        Collections.sort(students, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int firstIdx = students.get(0)[3];
        String firstName = names[firstIdx];

        int secondIdx = students.get(n-1)[3];
        String lastName = names[secondIdx];

        System.out.println(lastName);
        System.out.println(firstName);
    }
}
