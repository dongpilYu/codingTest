import java.util.*;

public class 프로그래머스_greedy_단속카메라 {
    public static void main(String[] args){

        int[][] arr ={ {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15} };
        int ans = 프로그래머스_greedy_단속카메라.solution(arr);

        System.out.println(ans);

    }
    public static int solution(int[][] routes){
        Arrays.sort(routes, (a,b)-> {
            if(a[0] > b[0])
                return 1;
            else
                return -1;
        });

        int idx = 0; // 봐야되는 시작 위치, 이미 cover한 영역을 다시 보지 않기 위한 변수
        int answer = 0; // 반환 값

        if(routes.length == 1)
            answer = 1;

        for(int i=1;i<routes.length;i++){
            for(int j=idx;j<i;j++){

                System.out.println(routes[i][0] + " " + routes[j][1]);
                if(routes[i][0] <= routes[j][1]){
                    // 커버 가능한 경우
                    if(idx == i - 1 && i == routes.length -1){
                        answer += 1;
                        break;
                    }
                }else{
                    // 커버 불가능한 경우
                    if(i == routes.length -1){
                        answer += 2;
                        break;
                    }else{
                        answer += 1;
                        idx = i;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
