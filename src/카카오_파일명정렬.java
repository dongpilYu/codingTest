/*
    카카오 > 파일명 정렬
    https://programmers.co.kr/learn/courses/30/lessons/17686

    문제 조건을 잘 파악해야 한다.
    tail이 없을 수 있다는 조건이 런타임 에러를 만들었다.

 */
import java.util.*;

public class 카카오_파일명정렬 {

    public static void main(String[] args) {

        String[] arr = {"A-25 thdn", "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] arr2 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String str1 = "ABC-";
        String str2 = "abc-";

        카카오_파일명정렬.solution(arr2);
        // 카카오_파일명정렬.tmp("img12.png", "img10.png");
    }
    public static void tmp(String o1, String o2) {
        int o1_s = 0;
        int o1_e = 0;
        int o2_s = 0;
        int o2_e = 0;
        boolean isNumStart1 = false;
        boolean isNumStart2 = false;

        for (int i = 0; i < o1.length(); i++) {
            if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                if(!isNumStart1) {
                    o1_s = i;
                    isNumStart1 = true;
                }
            }else{
                if(isNumStart1) {
                    o1_e = i;
                    break;
                }
            }
        }
        for (int i = 0; i < o2.length(); i++) {
            if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                if (!isNumStart2) {
                    o2_s = i;
                    isNumStart2 = true;
                }
            }else{
                if(isNumStart2) {
                    o2_e = i;
                    break;
                }
            }
        }
        if(o1_e == 0)
            o1_e = o1.length();
        if(o2_e == 0)
            o2_e = o2.length();
        String o1_first = o1.substring(0, o1_s);
        String o1_second = o1.substring(o1_s, o1_e);

        String o2_first = o2.substring(0, o2_s);
        String o2_second = o2.substring(o2_s, o2_e);

        if(o1_first.compareToIgnoreCase(o2_first) > 0){

        }else if(o1_first.compareToIgnoreCase(o2_first) == 0){

            int a = Integer.parseInt(o1_second);
            int b = Integer.parseInt(o2_second);

            if(a > b)
                System.out.println("a > b");
            else if(a == b)
                System.out.println("a = b");
            else
                System.out.println("a < b");

        } else{

        }

    }

    public static String[] solution(String[] files) {
        String[] answer = {};

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1_s = 0;
                int o1_e = 0;
                int o2_s = 0;
                int o2_e = 0;

                boolean isNumStart1 = false;
                boolean isNumStart2 = false;

                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                        if(!isNumStart1) {
                            o1_s = i;
                            isNumStart1 = true;
                        }
                    }else{
                        if(isNumStart1) {
                            o1_e = i;
                            break;
                        }
                    }
                }


                for (int i = 0; i < o2.length(); i++) {
                    if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                        if (!isNumStart2) {
                            o2_s = i;
                            isNumStart2 = true;
                        }
                    }else{
                        if(isNumStart2) {
                            o2_e = i;
                            break;
                        }
                    }
                }

                if(o1_e == 0)
                    o1_e = o1.length();
                if(o2_e == 0)
                    o2_e = o2.length();

                String o1_first = o1.substring(0, o1_s);
                String o1_second = o1.substring(o1_s, o1_e);
                String o2_first = o2.substring(0, o2_s);
                String o2_second = o2.substring(o2_s, o2_e);

                if(o1_first.compareToIgnoreCase(o2_first) > 0){
                    return 1;
                }else if(o1_first.compareToIgnoreCase(o2_first) == 0){
                    int a = Integer.parseInt(o1_second);
                    int b = Integer.parseInt(o2_second);

                    if(a > b)
                        return 1;
                    else if(a == b)
                        return 0;
                    else
                        return -1;

                } else{
                    return -1;
                }
            }
        });

        answer = files;
        for(int i=0;i<files.length;i++)
            System.out.println(files[i]);
        return answer;
    }
}
