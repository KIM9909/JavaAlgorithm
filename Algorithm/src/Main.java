import java.io.*;
import java.util.*;

public class Main {
    static String[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new String[8];

        for (int i=0; i<8; i++) {
            arr[i] = br.readLine();
        }

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0 && arr[i].charAt(j) == 'F') {
                        cnt ++;
                    }
                } else {
                    if (j % 2 != 0 && arr[i].charAt(j) == 'F') {
                        cnt ++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}