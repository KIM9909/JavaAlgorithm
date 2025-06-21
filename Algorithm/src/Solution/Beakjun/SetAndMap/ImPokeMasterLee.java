package Solution.Beakjun.SetAndMap;
// 1620. 나는야 포켓몬 마스터 이다솜

import java.io.*;
import java.util.*;
public class ImPokeMasterLee {
    static int N, M;
    static HashMap<String, Integer> PocketMonNumber;
    static HashMap<Integer, String> PocketMonName;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PocketMonNumber = new HashMap<>();
        PocketMonName = new HashMap<>();

        for (int i=1; i<=N; i++) {
            String name = br.readLine();

            PocketMonNumber.put(name, i);
            PocketMonName.put(i, name);
        }

        for (int i=0; i<M; i++) {
            String input = br.readLine();

            if (Character.isDigit(input.charAt(0))) {
                int number = Integer.parseInt(input);

                System.out.println(PocketMonName.get(number));
            } else {

                System.out.println(PocketMonNumber.get(input));
            }
        }
    }
}
