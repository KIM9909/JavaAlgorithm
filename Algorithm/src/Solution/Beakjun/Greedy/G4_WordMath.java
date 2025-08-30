package Solution.Beakjun.Greedy;
// 1339. Gold4_단어 수학

import java.io.*;
import java.util.*;
public class G4_WordMath {
    static int N;
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i=0; i<N; i++) {
            words[i] = br.readLine();
        }

        int res = cal();

        System.out.println(res);
    }

    static int cal() {
        // 알파벳과 각 가중치를 저장
        Map<Character, Integer> alphaWeight = new HashMap<>();

        for (String word : words) {
            // 첫번째 자리수부터
            int digit = 1;

            for (int i=word.length()-1; i>=0; i--) {
                char c = word.charAt(i);

                // 같은 알파벳이 나올 때 자리수만큼 가중치를 더해줌
                alphaWeight.put(c, alphaWeight.getOrDefault(c,0) + digit);
                // 다음 자리수는 곱하기 10
                digit *= 10;
            }
        }

        // 가중치만 따로 저장
        List<Integer> weights = new ArrayList<>(alphaWeight.values());
        // 가중치가 큰 순서로 정렬 (내림차순)
        Collections.sort(weights, Collections.reverseOrder());

        int res = 0;
        int num = 9; // 가장 큰 가중치에 가장 큰 숫자 할당

        for (int weight : weights) {
            res += weight * num;
            num --;
        }

        return res;
    }
}
