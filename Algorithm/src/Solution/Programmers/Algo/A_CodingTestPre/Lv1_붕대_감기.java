package Solution.Programmers.Algo.A_CodingTestPre;

public class Lv1_붕대_감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage[0] = 지속 회복 시간, bandage[1] = 초당 회복, bandage[2] = 추가 회복
        // attacks[i][0] = 공격 시간, attacks[i][1] = 공격력
        // health <= 0 이면 죽음
        // 모든 공격이 끝났을 때 플레이어의 남은 체력

        int maxHealth = health;
        int curHealth = health;
        int healCnt = 0;

        int maxTime = attacks[attacks.length - 1][0];
        int idx = 0;

        for (int i=1; i<=maxTime; i++) {

            if (attacks[idx][0] == i) {
                curHealth -= attacks[idx][1];
                healCnt = 0;
                idx ++;

                if (curHealth <= 0) {
                    return -1;
                }

                continue; // 공격 하는 시간에는 회복이 안됨
            }

            healCnt ++;

            if (curHealth < maxHealth) {
                if (curHealth + bandage[1] >= maxHealth) {
                    curHealth = maxHealth;
                } else {
                    curHealth += bandage[1];
                }
            }

            if (healCnt == bandage[0]) {
                if (curHealth < maxHealth) {
                    if (curHealth + bandage[2] >= maxHealth) {
                        curHealth = maxHealth;
                    } else {
                        curHealth += bandage[2];
                    }
                }
                healCnt = 0;
            }
        }

        return curHealth;
    }
}
