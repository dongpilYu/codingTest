/*
    https://www.acmicpc.net/problem/10974
    순열, 조합을 모두 출력하는 문제
 */
import java.util.*;
import java.util.Scanner;

public class 백준_모든_순열조합 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        // int[] arr = {1,2,3,4,5};
        permutation(a);
        // combination(a, arr);
    }
    public static void permutation(int num){
       int[] visited = new int[num];
       int[] output = new int[num];
       ArrayList<Integer> output2 = new ArrayList<>();
       perm(visited, num, output, 0);
    }
    public static void perm(int[] visited, int num, int[] output, int depth){
        if(num == 0){
            for(int i=0;i<output.length;i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
        }else{
            for(int i=0;i<visited.length;i++){
                if(visited[i] != 1){
                    visited[i] = 1;
                    output[depth] = i+1;
                    perm(visited, num-1, output, depth+1);
                    visited[i] = 0;
                }
            }
        }
        // 1 0 0 -> 1 1 0 -> 1 1 1 -> 1 2 3
        // 1 0 0 -> 1 0 1 -> 1 1 1 -> 1 3 2

        // 변수를 하나둬야 하는 것을 빠르게 캐치했어야 했는데...
    }
    public static void combination(int num, int[] arr){
        // arr : [1,2,3,4,5]로 구성
        // num은 5 이하의 상수로, arr의 원소 중 3개 뽑기 (조합)

        int[] visited = new int[arr.length];
        //comb(visited, 0, num);
        comb2(visited, 0, num);
    }
    public static void comb2(int[] visited, int idx, int num){

        if(num == 0){
            for(int i=0;i<visited.length;i++){
                if(visited[i] == 1)
                    System.out.print((i+1) + " ");
            }
            System.out.println();
        }else{
            for(int i=idx;i<visited.length;i++){
                visited[i] = 1;
                comb2(visited, i+1, num-1);
                visited[i] = 0;
            }
        }

    }
    public static void comb(int[] visited, int idx, int num){
        // arr이 {1,2,3,4,5} 처럼 연속된 수가 아니였다면
        // arr도 인자로 받았어야 함

        if(num == 0){
            for(int i=0;i<visited.length;i++){
                if(visited[i] == 1)
                    System.out.print((i+1) + " ");
            }
            System.out.println();
        }else if(idx < visited.length){
            visited[idx] = 1;
            comb(visited, idx+1, num-1);
            visited[idx] = 0;
            comb(visited, idx+1, num);
        }
    }
}
