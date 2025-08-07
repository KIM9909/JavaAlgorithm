package Solution.Beakjun.Tree;
// 12846. Platinum_5_무서운 아르바이트

import java.util.*;
import java.io.*;
public class P5_ScaryPartTimeJob {
    static int n;
    static int[] salaries;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 일을 할 수 있는 날의 수
        salaries = new int[n]; // 1일부터 n일 까지의 일급

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            salaries[i] = Integer.parseInt(st.nextToken());
        }

        long res = findMax();

        System.out.println(res);
    }

    static long findMax() {
        Stack<Integer> stack = new Stack<>();
        long maxValue = 0; // 최대 수익

        for (int i=0; i<=n; i++) {
            int currentSalary;
            if (i == n) { // i가 배열의 끝에 도달한 경우 stack 안에 남아있는 원소들 처리
                currentSalary = 0;
            } else {
                currentSalary = salaries[i];
            }

            // 스택이 비어있지 않고, 현재의 일급이 이전의 일급보다 낮은 경우 (감소하는 구간)
            while (!stack.isEmpty() && salaries[stack.peek()] > currentSalary) {
                int topIdx = stack.pop();
                int minSalary = salaries[topIdx]; // 현재 구간에서 가장 낮은 수라고 가정

                int days; // 연속된 날의 수
                if (stack.isEmpty()) { // 스택이 비어있다는 것
                    // 처음부터 지금까지의 일급이 현재보다 크거나 같다는 뜻
                    days = i;
                } else { // 스택이 비어있지 않은 경우
                    // 스택의 다음 원소부터 현재 직전까지의 일급이 현재보다 크거나 같다는 뜻
                    days = i - stack.peek() - 1;
                }

                long totalValue = (long) minSalary * days;
                maxValue = Math.max(maxValue, totalValue);
            }
            stack.push(i);
        }

        return maxValue;
    }
}
