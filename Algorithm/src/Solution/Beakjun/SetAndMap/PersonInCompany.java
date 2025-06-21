package Solution.Beakjun.SetAndMap;
// 7785. 회사에 있는 사람

import java.io.*;
import java.util.*;
public class PersonInCompany {
    static int n;
    static String person, action;
    static Set<String> stay;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        stay = new HashSet<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            person = st.nextToken();
            action = st.nextToken();

            if (action.equals("enter")) {
                stay.add(person);
            } else {
                stay.remove(person);
            }
        }

        List<String> result = new ArrayList<>(stay);
        Collections.sort(result, Collections.reverseOrder());

        for (String p : result) {
            sb.append(p).append('\n');
        }

        System.out.println(sb);
    }
}
