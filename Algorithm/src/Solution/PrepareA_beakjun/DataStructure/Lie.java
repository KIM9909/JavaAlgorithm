package Solution.PrepareA_beakjun.DataStructure;
// 1043. 거짓말

import java.util.*;
import java.io.*;
public class Lie {
    static int N, M;
    static int[] know_persons;
    static List<int[]> party;
    static boolean[] is_can;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        is_can = new boolean[M];

        for (int i=0; i<M; i++) {
            is_can[i] = true;
        }

        // 진실을 아는 사람들
        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        Set<Integer> know_truth = new HashSet<>();
        know_persons = new int[know]; // 진실을 아는 사람의 번호 저장
        for (int i=0; i<know; i++) {
            know_persons[i] = Integer.parseInt(st.nextToken());
            know_truth.add(know_persons[i]);
        }

        party = new ArrayList<>(); // 각 파티에 참여하는 사람들의 번호 저장
        int idx = 0;

        // 각 파티에 참여하는 사람들
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int person_cnt = Integer.parseInt(st.nextToken());
            int[] party_persons = new int[person_cnt];
            for (int j=0; j<person_cnt; j++) {
                int party_person = Integer.parseInt(st.nextToken());
                party_persons[j] = party_person;
            }
            party.add(idx, party_persons);
            idx ++;
        }

        // 진실이 다 전파될 때까지 반복
        boolean changed = true;
        while (changed) {
            changed = false;

            for (int i=0; i<M; i++) {
                int[] party_people = party.get(i);
                boolean has_know = false;

                // 이 파티에 진실을 아는 사람이 있는지 확인
                for (int person : party_people) {
                    if (know_truth.contains(person)) {
                        has_know = true;
                        break;
                    }
                }

                // 진실을 아는 사람이 있다면, 파티의 모든 사람이 진실을 알게 됨
                if (has_know) {
                    is_can[i] = false;
                    for (int person : party_people) {
                        if (!know_truth.contains(person)) {
                            know_truth.add(person);
                            changed = true; // 새로운 사람이 진실을 알게 됨
                        }
                    }
                }
            }
        }

        for (boolean can : is_can) {
            if (can == true) {
                cnt ++;
            }
        }

        System.out.println(cnt);
    }
}
