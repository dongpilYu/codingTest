/*
    2020 카카오 blind test - 자물쇠와 열쇠
    https://programmers.co.kr/learn/courses/30/lessons/60059
 */
import java.util.HashSet;
import java.util.Stack;

public class 카카오_자물쇠와열쇠_dfs_실패 {

    public static void main(String[] args){
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        // 001
        // printArr(rotate(key));
        // printArr(right(key));
        // printArr(left(key));
        // printArr(down(key));
        // printArr(up(key));

        boolean answer = 카카오_자물쇠와열쇠_dfs_실패.solution(key, lock);
        System.out.println(answer);
    }
    public static void printArr(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();

    }
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        Stack<int[][]> stack = new Stack<int[][]>();
        HashSet<int[][]> visited = new HashSet<int[][]>();
        stack.push(key);
        visited.add(key);
        while(!stack.empty()){

            int[][] pop_key = stack.pop();
            if(check(key, lock)){
                answer = true;
                break;
            }
            int[][] left_key = left(pop_key);
            int[][] right_key = right(pop_key);
            int[][] down_key = down(pop_key);
            int[][] up_key = up(pop_key);
            int[][] rotate_key = rotate(pop_key);

            if(!visited.contains(up_key))
                stack.push(up_key);
            if(!visited.contains(down_key))
                stack.push(down_key);
            if(!visited.contains(left_key))
                stack.push(left_key);
            if(!visited.contains(right_key))
                stack.push(right_key);
            if(!visited.contains(rotate_key))
                stack.push(rotate_key);
        }
        return answer;
    }
    public static boolean check(int[][] key, int[][] lock){

        boolean answer = true;
        for(int i=0;i<lock.length - key.length;i++){
            for(int j=0;j<lock.length - key.length;j++){

                for(int k=0;k<lock.length;k++){
                    for(int l=0;l<lock.length;l++){

                        if(k >= key.length || l >= key.length){
                            if(key[k][l] == 0){
                                answer = false;
                                break;
                            }
                        }
                        else{
                            if(key[k][l] == lock[k+i][l+j]) {
                                answer = false;
                                break; //
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
    public static int[][] rotate(int[][] key){
        int[][] result = new int[key.length][key.length];

        for(int i=0;i<key.length;i++){
            for(int j=0;j<key.length;j++){
                result[j][key.length-1-i] = key[i][j];
            }
        }

        return result;
    }
    public static int[][] left(int[][] key){

        int[][] result = new int[key.length][key.length];
        for(int i=0;i<key.length;i++){
            for(int j=0;j<key.length;j++){
                if(j+1 == key.length)
                    result[i][j] = 0;
                else
                    result[i][j] = key[i][j+1];
            }
        }

        return result;
    }
    public static int[][] right(int[][] key){
        int[][] result = new int[key.length][key.length];
        for(int i=0;i<key.length;i++){
            for(int j=0;j<key.length;j++){

                if(j == 0)
                    result[i][j] = 0;
                else
                    result[i][j] = key[i][j-1];
            }
        }
        return result;
    }
    public static int[][] up(int[][] key){
        int[][] result = new int[key.length][key.length];
        for(int i=0;i<key.length;i++){
            for(int j=0;j<key.length;j++){
                if(i+1 == key.length)
                    result[i][j] = 0;
                else
                    result[i][j] = key[i+1][j];
            }
        }

        return result;
    }
    public static int[][] down(int[][] key){
        int[][] result = new int[key.length][key.length];
        for(int i=0;i<key.length;i++){
            for(int j=0;j<key.length;j++){
                if(i == 0)
                    result[i][j] = 0;
                else
                    result[i][j] = key[i-1][j];
            }
        }
        return result;
    }
}
