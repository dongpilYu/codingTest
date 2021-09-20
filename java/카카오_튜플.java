/*
    프로그래머스 레벌2 > 튜플
    https://programmers.co.kr/learn/courses/30/lessons/64065
    
    길이가 작은 것 부터 하나씩 set에 넣고, set을 list로 변환
    
    다른 사람의 풀이)
    1. 정규 표현식으로 불필요한 문자 제거
        - replaceAll, trim, split
    2. 문자열 길이로 정렬  
        - Arrays.sort(arr, (a,b) -> {return a.length() > b.length();});
    3. HashSet 자체가 존재 여부에 따라 true/false를 반환하므로 반환값에 따라 배열에 삽입
    
    linkedList는 내부적으로 doubly linked list를 사용해 값을 저장
    linkedHashSet은 내부적으로 linked hashmap을 써서 값을 저장

    // set은 순서를 유지하지 않고, 중복을 허락하지 않는 자료구조
    // hashSet : 해시 알고리즘을 사용해 값을 저장
    // linkedHashSet : 저장 순서를 유지
    // linkedList vs linkedHashSet
 */
import java.util.*;

public class 카카오_튜플 {

    public static void main(String[] args){

        String str = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        int[] ans = 카카오_튜플.solution(str);
        for(int i=0;i<ans.length;i++)
            System.out.println(ans[i]);
    }
    public static int[] solution(String s) {
        int[] answer = {};

        String[] strs = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        
        HashMap<Integer, String[]> hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String[] s4 = strs[i].split(",");
            hm.put(s4.length, s4);
        }

        for(Map.Entry<Integer, String[]> entry : hm.entrySet()){
            int key = entry.getKey();
            String[] str = entry.getValue();
        }


        Set<String> hs2 = new HashSet<>();
        answer = new int[strs.length];
        int idx = 0;
        for(int i=1;i<strs.length+1;i++){
            String[] str = hm.get(i);
            for(int j=0;j<str.length;j++){
                if(hs2.add(str[j])){
                    answer[idx++] = Integer.parseInt(str[j]);
                }
            }
        }
        /*
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();
        for(int i=1;i<strs.length+1;i++){
            String[] str = hm.get(i);
            for(int j=0;j<str.length;j++){
                if(!hs.contains(str[j]))
                    hs.add(Integer.parseInt(str[j]));
            }
        }

        int idx = 0;
        for(Integer i : hs){
            answer[idx++] = i;
        }
        */

        return answer;
    }
}
