package Solution.Beakjun.String;
// 1343. Silver5_폴리오미노

import java.util.*;
import java.io.*;
public class S5_Polyomino {
    static String board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        board = br.readLine();

        int cnt = 0;
        for (int i=0; i<board.length(); i++) {
            if (String.valueOf(board.charAt(i)).equals("X")) {
                cnt ++;
            }
            if (String.valueOf(board.charAt(i)).equals(".") || i == board.length() - 1){
                if (cnt > 0) {
                    if (cnt % 2 == 0) {
                        if (cnt % 4 == 2) {
                            for (int j=0; j<cnt / 4; j++) {
                                sb.append("AAAA");
                            }
                            sb.append("BB");
                            cnt = 0;
                        } else if (cnt % 4 == 0) {
                            for (int j=0; j<cnt / 4; j++) {
                                sb.append("AAAA");
                            }
                            cnt = 0;
                        }
                    } else {
                        System.out.println(-1);
                        return;
                    }
                }
                if (String.valueOf(board.charAt(i)).equals(".")) {
                    sb.append(".");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
