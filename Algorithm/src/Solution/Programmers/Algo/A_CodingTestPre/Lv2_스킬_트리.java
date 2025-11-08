package Solution.Programmers.Algo.A_CodingTestPre;

public class Lv2_스킬_트리 {
    public int solution(String skill, String[] skill_trees) {
        int cnt = 0;

        for (String tree : skill_trees) {
            if (check(skill, tree)) {
                cnt ++;
            }
        }

        return cnt;
    }

    static boolean check (String skill, String tree) {
        int skillIdx = 0;

        for (char c : tree.toCharArray()) {
            int idx = skill.indexOf(c);

            if (idx == -1) {
                continue;
            }

            if (idx == skillIdx) {
                skillIdx ++;
            } else {
                return false;
            }
        }

        return true;
    }
}
