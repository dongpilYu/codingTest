/*
    프로그래머스 코딩테스트 연습 > 해시 > 전화번호 목록 > LV2
    https://programmers.co.kr/learn/courses/30/lessons/42577
    해시를 사용하지 않고, 리스트를 사용해 풂
 */

import java.util.Arrays;

public class 프로그래머스_해시_전화번호목록 {
    public static boolean solution(String[] phone_book){
        boolean answer = true;
        // phone_book 배열 정렬 후, 바로 뒤에 요소와 비교

        Arrays.sort(phone_book);
        /*
        for(String i : phone_book){
            System.out.println(i);
        }

        */
        for(int i=0; i<phone_book.length-1;i++){
            if(phone_book[i].length() > phone_book[i+1].length()){
                continue;
            }
            if(phone_book[i].equals(phone_book[i+1].substring(0, phone_book[i].length()))){
                answer = false;
                break;
            }

        }
        return answer;
    }
    public static void main(String[] args){
        String[] phone_book = new String[] {"123","456","789"};
        System.out.println(프로그래머스_해시_전화번호목록.solution(phone_book));

    }

}
