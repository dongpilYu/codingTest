/*
    프로그래머스 코딩테스트 연습 > 해시 > 완주하지 못한 선수
    해시 맵 사용
 */

import java.util.HashMap;

public class hash_1 {
    public static void main(String[] args){

        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};

        String str = hash_1.solution(participant, completion);
        System.out.println(str);
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map1 = new HashMap<String, Integer>();

        for(int i=0;i<completion.length;i++){
            if(map1.containsKey(completion[i])) {
                map1.put(completion[i], map1.get(completion[i]) + 1);
            }else{
                map1.put(completion[i], 1);
            }
        }
        // map1.put(completion[i], map1.getOrDefault(completion[i], 0) + 1); 을 썼으면 더 좋았을 듯

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
