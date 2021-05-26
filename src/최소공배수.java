import java.util.ArrayList;
import java.util.Arrays;

public class 최소공배수 {
    public static void main(String[] args){

        int[] arr = {2,6,8,14,35, 70, 70};
        // int[] arr = {1,2,3, 7, 14, 37, 74, 90};
        // int[] arr = {1, 2, 4, 12};
        // 1 1 3 7 7 37 37 74 : 2
        // 1 1 3 1 1 37 37 74 : 7
        // 1 1 3 1 1 1 1 2 : 37
        int sol = 최소공배수.solution(arr);

        System.out.println(sol);
    }
    public static int solution(int[] arr) {
        int answer = 1;
        int count = 0;

        ArrayList<Integer> arr2 = new ArrayList<>();
        int maxi = 100;
        int num = 2;
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % num == 0) {
                    count ++;
                    arr2.add(i);
                }
            }
            if (count > 1) {
                answer *= num;
                System.out.println("num: " + num);
                for (int i = 0; i < arr2.size(); i++)
                    arr[arr2.get(i)] /= num;
            }else
                num += 1;

            count = 0;
            arr2.clear();

            if(num >= maxi)
                break;
        }


        for(int i=0;i<arr.length;i++){
            answer *= arr[i];
            System.out.print(arr[i] + " ");
        }
        return answer;
    }
}
