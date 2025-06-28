import java.io.*;
import java.util.*;

public class Main {
    static int x,y,w,h;
    static int minDistance = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int xMin = 0;
        xMin = Math.min(x-0, w-x);

        int yMin = 0;
        yMin = Math.min(y-0, h-y);

        minDistance = Math.min(xMin, yMin);

        System.out.println(minDistance);
    }
}