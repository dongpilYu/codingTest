/*
    문자열과 상수가 주어질 떄, 상수를 길이로 하는 문자열 조합, 순열을 만들라
 */
import java.util.*;

public class 문자열_조합_순열 {

    public static void main(String[] args) {

        String str = "ABCD";
        combination(str.toCharArray(), "", 0, 2);
        System.out.println("-----------------------------------");

        int[] arr = new int[str.length()];
        combination_with_visited(str.toCharArray(), "",0,  2);
        System.out.println("-----------------------------------");

        int[] arr2 = new int[str.length()];
        permutation_with_visited(str.toCharArray(), "", 2, arr2);
    }
    public static void combination_with_visited(char[] arr, String str, int idx, int num){

        // visited를 사용하려 했지만, str에 이미 저장되어 있어 필요 없어짐
        // 로직은 visited을 사용한 것과 비슷

        if(num == 0)
            System.out.println(str);

        for(int i=idx;i<arr.length;i++){
            combination_with_visited(arr, str + arr[i], i+1,num-1);
        }
    }
    public static void permutation_with_visited(char[] arr, String str, int num, int[] visited){

        if(num == 0){
            System.out.println(str);
        }
        for(int i=0;i<arr.length;i++){
            if(visited[i] != 1) {
                visited[i] = 1;
                permutation_with_visited(arr, str + arr[i],num-1, visited);
                visited[i] = 0;
            }
        }
    }
    public static void combination(char[] arr, String str, int idx, int num) {
        // arr : 문자열, 불변
        // length : 포함한 문자열 길이, 가변 -> str의 길이가 length이므로 삭제
        // str : 포함한 문자열, 불변
        // idx : arr를 탐색하는 인덱스 (재귀의 깊이), 0 -> length까지, 가변
        // num : 고를 문자 개수, 가변, num이 0이면, 다 고른 것, num이 idx와 같으면 다 고른 것

        // 앞에서 부터 하면, ab ac ad ... 이런 순서로 할 수 있음
        // stringbuilder를 쓰니까, 얕은 복사를 해서 의미가 없음
        // 어떻게 해야 할까?
        // char array 합쳐야하는 부분만 stringBuilder로 합친 후 한번만 더 함

        if(num == 0){
            // 이미 다 고름
            System.out.println(str);
        } else if(arr.length - idx == num){
            // 남은 개수 num과 고를 개수가 같을 때
            StringBuilder st = new StringBuilder();
            for(int i=idx;i<arr.length;i++)
                st.append(arr[i]);
            System.out.println(str + st.toString());
            // java 1.5 부터는 +는 concat과 다르 내부적으로 StringBuilder로 변환하여 작업함
        } else{
            combination(arr, str + arr[idx], idx + 1 , num - 1);
            combination(arr, str, idx + 1 , num);
        }
    }
}
