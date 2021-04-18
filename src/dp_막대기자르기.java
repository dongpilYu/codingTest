/*
    dp 기본 > 막대기 자르기

 */
import java.util.*;

public class dp_막대기자르기 {
    public static void main(String[] args){
        int length = 10;
        int[] price = {0,1,5,8,9,10,17,17,20,24,30};

        solution(length, price);
    }
    public static void solution(int length, int[] price){

        int[] maxi = price;
        maxi[0] = price[0];
        maxi[1] = price[1];
        // i = 3 / 1
        // i = 4 / 1,2
        // i = 5 / 1,2
        // i = 6 / 1,2,3
        for(int i=2;i<price.length;i++) {
            for (int j = 1; j < i / 2 + 1; j++)
                maxi[i] = Math.max(maxi[i], maxi[i - j] + maxi[j]);
        }
    }
}
