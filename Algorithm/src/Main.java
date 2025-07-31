import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> firstSection;
    static List<Integer> secondSection;
    static int firstSum;
    static int secondSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        firstSection = new ArrayList<>();
        secondSection = new ArrayList<>();

        for (int i=0; i<4; i++) {
            firstSection.add(Integer.parseInt(br.readLine()));
        }

        for (int i=0; i<2; i++) {
            secondSection.add(Integer.parseInt(br.readLine()));
        }

        firstSection.sort(Collections.reverseOrder());
        secondSection.sort(Collections.reverseOrder());

        for (int i=0; i<3; i++) {
            firstSum += firstSection.get(i);
        }

        secondSum += secondSection.get(0);

        System.out.println(firstSum + secondSum);
    }
}