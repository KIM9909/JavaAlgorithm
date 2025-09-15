package Solution.Programmers.Algo.Hash;
// Lv.2 전화번호 목록

import java.util.*;
class PhoneNumbers {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap();

        for (String number : phone_book) {
            map.put(number, true);
        }

        for (String number : phone_book) {
            for (int i=1; i<number.length(); i++) {
                String prefix = number.substring(0, i);

                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }
}