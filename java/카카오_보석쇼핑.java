/*
    카카오 - 보석 쇼핑
    https://programmers.co.kr/learn/courses/30/lessons/67258
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class 카카오_보석쇼핑 {
    public static int[] solution(String[] gems){
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        for (int i = 0; i < gems.length; i++) {
            if (map1.containsKey(gems[i])) {
                map1.put(gems[i], map1.get(gems[i]) + 1);
            } else {
                map1.put(gems[i], 1);
            }
        }
        Iterator<String> mapIter = map1.keySet().iterator();
        while(mapIter.hasNext()){
            String key = mapIter.next();
            System.out.println(key + ": " + map1.get(key));
        }
        /*
        결과 예시
        EMERALD: 1
        SAPPHIRE: 1
        RUBY: 2
        DIA: 4

        HashMap 시간 복잡도
        - 입력과 삭제에 대해 O(1)
        */

        /*
         * 투 포인터 방식으로 탐색
         * 입력이 10만이므로, n^2은 안되고, nlon or n으로 결과를 내야함
         * 길이가 같은 구간이 여러 개 일 경우, start_idx가 작은 걸 출력해야 함. 따라서, 뒤에서 부터
         * hashMap
         * LinkedHashMap : 삽입한 순서대로 탐색하고 싶을 때,
         * TreeMap : 특정한 기준에 의해서 정렬된 순서로 탐색하고 싶을 때,
         */

        int start_idx = 1;
        int end_idx = gems.length;
        // String[] arr = {"AA", "AB", "AC", "AA", "AC"};
        // start_idx = 1, end_idx = 5
        for(int i=gems.length-1;i>=0;i--){
            if(map1.get(gems[i]) == 1){
                break;
            }else {
                map1.put(gems[i], map1.get(gems[i]) - 1);
                end_idx--;
            }
        }
        /*
        Iterator<String> mapIter2 = map1.keySet().iterator();
        while(mapIter2.hasNext()){
            String key = mapIter2.next();
            //System.out.println(key + ": " + map1.get(key));
        }
        */
        for (int i = 0; i < gems.length; i++) {
            if (map1.get(gems[i]) == 1) {
                break;
            }else{
                map1.put(gems[i], map1.get(gems[i]) - 1);
                start_idx ++;
            }
        }
        /*
        Iterator<String> mapIter3 = map1.keySet().iterator();
        while(mapIter3.hasNext()){
            String key = mapIter3.next();
            System.out.println(key + ": " + map1.get(key));
        }
        */
        int [] answer = {start_idx, end_idx};

        return answer;

        /*
            반례)
            E S E S T W W W R E S T R W
         */




    }
    public static void main(String[] args) throws IOException {
        String[] arr = {"AA", "AB", "AC", "AA", "AC"};
        카카오_보석쇼핑.solution(arr);
    }
}