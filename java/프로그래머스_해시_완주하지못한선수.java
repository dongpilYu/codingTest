/*
    프로그래머스 코딩테스트 연습 > 해시 > 완주하지 못한 선수 > LV1
    https://programmers.co.kr/learn/courses/30/lessons/42576
    해시 맵 사용
 */

import java.util.HashMap;

public class 프로그래머스_해시_완주하지못한선수 {
    public static void main(String[] args){

        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};

        String str = 프로그래머스_해시_완주하지못한선수.solution(participant, completion);
        System.out.println(str);
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map1 = new HashMap<>();

        for(int i=0;i<completion.length;i++)
            map1.put(completion[i], map1.getOrDefault(completion[i], 0) + 1);


        for(int i=0;i<participant.length;i++){
            if(map1.containsKey(participant[i])){
                if(map1.get(participant[i]) == 1)
                    map1.remove(participant[i]);
                else
                    map1.put(participant[i], map1.get(participant[i]) - 1);
            }else{
                answer = participant[i];
                break;
            }

        }
        return answer;
    }
}
