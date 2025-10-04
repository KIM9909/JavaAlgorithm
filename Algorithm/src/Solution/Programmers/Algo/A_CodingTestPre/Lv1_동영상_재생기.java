package Solution.Programmers.Algo.A_CodingTestPre;

public class Lv1_동영상_재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = toSecond(video_len);
        int currentPos = toSecond(pos);
        int opStart = toSecond(op_start);
        int opEnd = toSecond(op_end);

        if (opStart <= currentPos && currentPos <= opEnd) {
            currentPos = opEnd;
        }

        for (String command : commands) {
            if (command.equals("next")) {
                currentPos += 10;
                if (currentPos > videoLen) {
                    currentPos = videoLen;
                }
            } else {
                currentPos -= 10;
                if (currentPos < 0) {
                    currentPos = 0;
                }
            }

            if (opStart <= currentPos && currentPos <= opEnd) {
                currentPos = opEnd;
            }
        }

        String res = changeFormat(currentPos);

        return res;
    }

    static int toSecond(String target) {
        String[] parts = target.split(":");

        int minute = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);

        return minute * 60 + second;
    }

    static String changeFormat(int currentPos) {
        int minutes = currentPos / 60;
        int seconds = currentPos % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}
