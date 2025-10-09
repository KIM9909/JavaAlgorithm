package Solution.Beakjun.Math;

import java.io.*;
public class S5_분수찾기 {
    static int X;
    static int idx = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());

        int child = 1;
        int parent = 1;

        if (idx == X) {
            String res = child + "/" + parent;
            System.out.println(res);
            return;
        }

        if (child == 1 && parent == 1) {
            parent ++;
            idx ++;
            if (idx == X) {
                String res = child + "/" + parent;
                System.out.println(res);
                return;
            }
        }

        while (true) {
            if (child == 1 && parent > 1) {
                while (parent > 1) {
                    parent --;
                    child ++;
                    idx ++;
                    if (idx == X) {
                        String res = child + "/" + parent;
                        System.out.println(res);
                        return;
                    }
                }

                child ++;
                idx ++;
                if (idx == X) {
                    String res = child + "/" + parent;
                    System.out.println(res);
                    return;
                }
            }

            if (child > 1 && parent == 1) {
                while (child > 1) {
                    parent ++;
                    child --;
                    idx ++;
                    if (idx == X) {
                        String res = child + "/" + parent;
                        System.out.println(res);
                        return;
                    }
                }

                parent ++;
                idx ++;
                if (idx == X) {
                    String res = child + "/" + parent;
                    System.out.println(res);
                    return;
                }
            }
        }
    }
}
