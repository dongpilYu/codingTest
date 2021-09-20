/*
    카카오 인턴 - 수식 최대화
    https://programmers.co.kr/learn/courses/30/lessons/67257

    반복문을 돌릴 때, 내부에서 인덱스를 건들이는 행위는 위험하다.
    링크드리스트가 좋은 선택지가 아닐 수 있음

    분할 정복 vs 동적 프로그래밍
    문제를 작은 문제들로 나누어 계산하는 방식이 공통점이고,
    작은 문제들끼리 중복이 되는 지 여부가 차이점이다.
    작은 문제들끼리 중복이 발생할 경우, 계산 결과를 저장해두면
    중복된 상황이 발생했을 때, 재연산을 할 필요가 없다.

    메모이제이션은 dp에서 사용하는 기법이긴 하나, dp에 국한된 개념은 아니다.
    어떤 문제를 해결하는데, 이전에 계산해 둔 값을 저장해두고 사용한다면 메모이제이션을 활용한다.
 */

import java.util.*;

public class 카카오_수식최대화 {

    public static void main(String[] args){

        String expression = "100-200*300-500+20";

        long answer = 카카오_수식최대화.solution(expression);
        System.out.println("answer: " + answer);
    }
    public static long solution(String expression){
        long answer = 0;
        char[][] arr = {
                {'+', '-', '*'},
                {'+', '*', '-'},
                {'-', '+', '*'},
                {'-', '*', '+'},
                {'*', '+', '-'},
                {'*', '-', '+'}
        };
        for(int i=0;i<6;i++){
            long num = divide(expression, arr[i], 0);
            if(Math.abs(num) > answer)
                answer = Math.abs(num);
        }
        return answer;
    }
    public static void printArr(String[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+ " ");
        System.out.println();
    }

    public static long divide(String expression, char[] arr, int idx){

        long answer = 0;
        if(idx == 3 || isNumeric(expression)){
            // System.out.println(expression);
            return Long.parseLong(expression);
        }

        String[] splited = expression.split(String.valueOf("\\" + arr[idx]));
        // printArr(splited);
        // System.out.println("op: " + arr[idx]);

        if(arr[idx] == '*')
            answer = 1;
        else
            answer = 0;

        for(int i=0;i<splited.length;i++) {
            // System.out.println("point: " + splited[i]);
            long num = divide(splited[i], arr, idx+1);

            if(arr[idx] == '*'){
                answer *= num;
            }else if(arr[idx] == '-'){
                if(i == 0)
                    answer += num;
                else
                    answer -= num;
            }else if(arr[idx] == '+'){
                answer += num;
            }
        }
        // System.out.println("medium: " + answer);
        return answer;
    }
    public static boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static long solution2(String expression) {
        long answer = 0;

        int idx = 0;
        LinkedList<Character> op = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();

        for(int i=0;i<expression.length();i++){

            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                num.add(Integer.parseInt(expression.substring(idx, i)));
                op.add(expression.charAt(i));
                idx = i+1;
            }
            if(i == expression.length()-1){
                num.add(Integer.parseInt(expression.substring(idx, i+1)));
            }
        }
        System.out.println(num);
        System.out.println(op);
        // "100-200*300-500+20"
        // 100 200 300 500 20
        // - * - +
        // -100 300 500 20
        // * - +

        // 6 case
        // 1. * > + > -
        // 2. * > - > +
        // 3. + > * > -
        // 4. + > - > *
        // 5. - > * > +
        // 6. - > + > *


        /*
            num = [100, 200, 300, 500, 20]
            op = [-, *, -, +]
            - > + > *
            -100 -200 20
            * +
            -100 -180
            *
            18000
         */

        return answer;
    }
}
