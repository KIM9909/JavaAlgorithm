package Solution.Beakjun.Implement;
// 1244. Silver4_스위치 켜고 끄기

import java.io.*;
import java.util.*;
public class S4_SwitchOnOff {
    static int N, students;
    static int[] arr;
    static int gender, getNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        students = Integer.parseInt(br.readLine());

        for (int i=0; i<students; i++) {
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            getNum = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j=getNum; j<=N; j+=getNum) {
                    if (arr[j] == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = 0;
                    }
                }
            } else {
                List<Integer> idxes = new ArrayList<>();
                idxes.add(getNum);

                int add = 1;
                while (true) {
                    if (getNum-add <= 0 || getNum+add > N || arr[getNum-add] != arr[getNum+add]) {
                        break;
                    }

                    if (arr[getNum-add] == arr[getNum+add]) {
                        idxes.add(getNum-add);
                        idxes.add(getNum+add);

                        add ++;
                    }
                }

                for (int idx : idxes) {
                    if (arr[idx] == 0) {
                        arr[idx] = 1;
                    } else {
                        arr[idx] = 0;
                    }
                }
            }
        }

        for (int i=1; i<=N; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
