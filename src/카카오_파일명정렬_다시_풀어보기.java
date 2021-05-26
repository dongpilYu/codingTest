import java.util.Arrays;
import java.util.Comparator;

public class 카카오_파일명정렬_다시_풀어보기 {

    public static void main(String[] args){

        String[] input = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] input2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] answer = 카카오_파일명정렬_다시_풀어보기.solution(input2);

        for(int i=0;i<answer.length;i++)
            System.out.println(answer[i]);
    }

    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                // 두 문자열을 head, body, tail로 나누고 각각을 비교
                int o1_start = 0;
                int o1_end = 0;
                int o2_start = 0;
                int o2_end = 0;
                boolean isNumStart1 = false;
                boolean isNumStart2 = false;

                for(int i=0;i<o1.length();i++){

                    if(o1.charAt(i) >= '0' && o1.charAt(i) <= '9'){
                        if(!isNumStart1){
                            isNumStart1 = true;
                            o1_start = i;
                        }
                    }else{
                        if(isNumStart1){
                            o1_end = i;
                            break;
                        }
                    }
                }

                for(int i=0;i<o2.length();i++){

                    if(o2.charAt(i) >= '0' && o2.charAt(i) <= '9'){
                        if(!isNumStart2){
                            isNumStart2 = true;
                            o2_start = i;
                        }
                    }else{
                        if(isNumStart2){
                            o2_end = i;
                            break;
                        }
                    }
                }

                String head1 = o1.substring(0, o1_start);
                String head2 = o2.substring(0, o2_start);
                String body1 = "";
                String body2 = "";

                if(o1_end == 0)
                    body1 = o1.substring(o1_start, o1.length());
                else
                    body1 = o1.substring(o1_start, o1_end);
                if(o2_end == 0)
                    body2 = o2.substring(o2_start, o2.length());
                else
                    body2 = o2.substring(o2_start, o2_end);

                // head가 대소문자 신경 안 쓰고 똑같을 경우
                // return 0
                if(head1.compareToIgnoreCase(head2) > 0){
                    return 1;
                }else if(head1.compareToIgnoreCase(head2) == 0){
                   int a = Integer.parseInt(body1);
                   int b = Integer.parseInt(body2);

                   if(a > b)
                       return 1;
                   else if(a == b)
                       return 0;
                   else
                       return -1;
                }else{
                    return -1;
                }

                // head가 같을 때, body가 똑같을 경우
                // return 0

            }
        });

        String[] ans = files;
        return ans;
    }
}
