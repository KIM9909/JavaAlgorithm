package Solution.Beakjun.Sort;

import java.io.*;
import java.util.*;
public class S5_좌표_정렬하기 {
    static int N;
    static int x, y;
    static List<int[]> points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        points = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            points.add(new int[] {x, y});
        }

        Collections.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int[] point : points) {
            int a = point[0];
            int b = point[1];

            sb.append(a).append(" ").append(b).append("\n");
        }

        System.out.println(sb);
    }
 }
