/*
        카카오 - 문자열 압축
       https://programmers.co.kr/learn/courses/30/lessons/60057

        반복문 내부에서 인덱스 건들지 말자
        어떤 변수가 어떤 역할을 하는지 명확하게 해야 함
*/
public class 카카오_문자열압축 {

    public static void main(String[] args){
        카카오_문자열압축.solution("aabbbcb");
    }
    public static int solution(String s){
        int answer = 1000;

        for(int i=1;i<=s.length();i++){
            String str = tmp(s, i);
            if(str.length() < answer)
                answer = str.length();
        }
        return answer;
    }

    public static String tmp(String s, int d){
        String result = "";
        int idx = 0;

        while(true){
            int a = 0;
            a++;
            int first = idx + (a-1) * d;
            int second = idx + a * d;
            int third = idx + (a+1) * d;

            if(s.length() < third){

                if(a != 1)
                    result += (Integer.toString(a));

                result += s.substring(first, second);
                result += s.substring(second);
                break;
            }
            if(s.substring(first, second).compareTo(s.substring(second, third)) != 0){
                idx += a*d;
                if(a != 1)
                    result += Integer.toString(a);
                result += s.substring(first, second);
                a = 0;
            }

        }

        /*
        for(int a=1;;a++){
            int first = idx + (a-1)*d;
            int second = idx + (a)*d;
            int third = idx + (a+1)*d;

            if(s.length() < third) {
                 if(a != 1)
                    result += (Integer.toString(a));
                result += s.substring(first, second);
                result += s.substring(second);
                break;
            }

            if(s.substring(first, second).compareTo(s.substring(second, third)) != 0){
                idx += a * d;
                if(a != 1)
                    result += (Integer.toString(a));
                result += s.substring(first, second);
                a = 0;
            }
        }
        */

        return result;

    }
}
