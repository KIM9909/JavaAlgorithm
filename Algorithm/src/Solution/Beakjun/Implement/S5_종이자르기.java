package Solution.Beakjun.Implement;

import java.io.*;
import java.util.*;
public class S5_종이자르기 {
    static int width, height;
    static int cut;
    static int direction, cutNum;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> horizontal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        horizontal.add(0);
        horizontal.add(height);
        vertical.add(0);
        vertical.add(width);

        arr = new int[height][width];

        cut = Integer.parseInt(br.readLine());

        for (int i=0; i<cut; i++) {
            st = new StringTokenizer(br.readLine());
            direction = Integer.parseInt(st.nextToken());
            cutNum = Integer.parseInt(st.nextToken());

            if (direction == 0) {
                horizontal.add(cutNum);
            } else {
                vertical.add(cutNum);
            }
        }

        Collections.sort(horizontal);
        Collections.sort(vertical);

        int maxH = 0;
        for (int i=1; i<horizontal.size(); i++) {
            maxH = Math.max(maxH, horizontal.get(i) - horizontal.get(i-1));
        }

        int maxV = 0;
        for (int i=1; i<vertical.size(); i++) {
            maxV = Math.max(maxV, vertical.get(i) - vertical.get(i-1));
        }

        int res = maxH * maxV;

        System.out.println(res);
    }
}
