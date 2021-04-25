/*
    프로그래머스 레벌2 > 튜플
    https://programmers.co.kr/learn/courses/30/lessons/64065
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

        String s2 = s.replace("{", "");
        String s3 = s2.replace("}}", "");
        String[] strs = s3.split("},");
        //for(int i=0;i<strs.length;i++)
        //    System.out.println(strs[i]);

        HashMap<Integer, String[]> hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String[] s4 = strs[i].split(",");
            hm.put(s4.length, s4);
        }

        for(Map.Entry<Integer, String[]> entry : hm.entrySet()){
            int key = entry.getKey();
            String[] str = entry.getValue();
            /*
            System.out.println("key: " + key);
            for(int i=0;i<str.length;i++)
                System.out.print(str[i] + " ");
            System.out.println();
            */
        }

        // set은 순서를 유지하지 않고, 중복을 허락하지 않는 자료구조
        // hashSet : 해시 알고리즘을 사용해 값을 저장
        // linkedHashSet : 저장 순서를 유지
        // linkedList vs linkedHashSet

        LinkedHashSet<Integer> hs = new LinkedHashSet<>();
        for(int i=1;i<strs.length+1;i++){
            String[] str = hm.get(i);
            for(int j=0;j<str.length;j++){
                if(!hs.contains(str[j]))
                    hs.add(Integer.parseInt(str[j]));
            }
        }

        answer = new int[hs.size()];
        int idx = 0;
        for(Integer i : hs){
            answer[idx++] = i;
        }


        return answer;
    }
}
