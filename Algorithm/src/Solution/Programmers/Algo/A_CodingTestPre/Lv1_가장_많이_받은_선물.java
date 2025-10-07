package Solution.Programmers.Algo.A_CodingTestPre;

import java.util.*;
public class Lv1_가장_많이_받은_선물 {
    static int maxGiftCnt = Integer.MIN_VALUE;
    static String[] friends;
    static String[] gifts;
    public int solution(String[] friends, String[] gifts) {
        this.friends = friends;
        this.gifts = gifts;

        Map<String, List<String>> map = new HashMap<>();

        // 친구별로 List 생성
        for (String friend : friends) {
            map.put(friend, new ArrayList<>());
        }

        // 선물을 준 사람과 받은 사람들 저장
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String reciever = parts[1];

            map.get(giver).add(reciever);
        }

        // 각각의 선물 지수 저장
        Map<String, Integer> giftScore = new HashMap<>();
        for (String friend : friends) {
            int givceCnt = map.get(friend).size();

            int recieveCnt = 0;
            for (String other : friends) {
                if (friend.equals(other)) {
                    continue;
                }

                for (String target : map.get(other)) {
                    if (friend.equals(target)) {
                        recieveCnt ++;
                    }
                }
            }

            giftScore.put(friend, givceCnt - recieveCnt);
        }

        for (String friend : friends) {
            int giftCnt = cal(friend, map, giftScore);
            maxGiftCnt = Math.max(maxGiftCnt, giftCnt);
        }

        return maxGiftCnt;
    }

    static int cal(String friend, Map<String, List<String>> map,
                   Map<String, Integer> giftScore) {
        int cnt = 0;

        for (String other : friends) {
            if (other.equals(friend)) {
                continue;
            }

            int friendToOther = 0;
            for (String target : map.get(friend)) {
                if (target.equals(other)) {
                    friendToOther ++;
                }
            }

            int otherToFriend = 0;
            for (String target : map.get(other)) {
                if (target.equals(friend)) {
                    otherToFriend ++;
                }
            }

            if (friendToOther > otherToFriend) {
                cnt ++;
            } else {
                if (friendToOther == otherToFriend) {
                    if (giftScore.get(friend) > giftScore.get(other)) {
                        cnt ++;
                    }
                }
            }
        }

        return cnt;
    }
}
