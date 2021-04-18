/*
    프로그래머스 dp > 정수 삼각형
    https://programmers.co.kr/learn/courses/30/lessons/43105
 */
import java.util.*;

public class 프로그래머스_dp_정수삼각형 {
    public static void main(String[] args){
        int[][] triangle = {
                {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
        };

        // 10 15
        // 18 16 15
        // 20 25 20 19
        // 24
        int ans = 프로그래머스_dp_정수삼각형.solution(triangle);
        System.out.println(ans);

    }
    public static int solution(int[][] triangle) {
        int answer = 0;

        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0){
                    triangle[i][j] += triangle[i-1][j];
                }else if(j==triangle[i].length-1){
                    triangle[i][j] += triangle[i-1][j-1];
                }else{
                    triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
                // System.out.print(triangle[i][j] + " ");
            }
            // System.out.println();
        }

        for(int i=0;i<triangle[triangle.length-1].length;i++) {
            // System.out.print(triangle[triangle.length-1][i] + " ");
            if(answer < triangle[triangle.length-1][i])
                answer = triangle[triangle.length-1][i];
        }
        // System.out.println();
        return answer;
    }
}
