/*
    프로그래머스 레벌3 > dp > n으로 표현 > LV3
    https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
 */
import java.util.*;
public class 프로그래머스_dp_n으로표현 {
    private static int n;
    private static int target;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args){
        프로그래머스_dp_n으로표현.solution(5, 12);
    }
    public static int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    private static void dfs(int count, int prev) {
        if (count > 8) {
            answer = -1;
            return;
        }

        if (prev == target) {
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;
        for (int i = 0; i < 8 - count; i++) {
            int newCount = count + i + 1;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, prev / tempN);
            dfs(newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }
}
