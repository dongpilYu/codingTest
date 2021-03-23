/*
    프로그래머스 레벌2 > 해시
    https://programmers.co.kr/learn/courses/30/lessons/42578
 */
import java.util.HashMap;

public class hash_3 {

    public static int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, Integer> map1 = new HashMap<String,Integer>();

        for(int i=0;i<clothes.length;i++){

            if(map1.containsKey(clothes[i][1]))
                map1.put(clothes[i][1], map1.get(clothes[i][1]) + 1);


            else {
                map1.put(clothes[i][1], 1);
            }
        }

        int num2 = 1;
        for(String key : map1.keySet()) {
            num2 *= (map1.get(key) + 1);
        }
        answer = num2 - 1;

        return answer;
    }
    public static void main(String[] args){

        String[][] input = new String[][]{
                {"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}

        };

        int num = hash_3.solution(input);
        System.out.println(num);

    }
}
