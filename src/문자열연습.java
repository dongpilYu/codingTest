import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 문자열연습 {
    public static void main(String[] args){

        /*
            string startswith
        */
        String str1 = "I have a book";
        boolean iHave = str1.startsWith("I have");

        /*
            string toLowerCase, toUpperCase
            영문자가 아니면 영향없음, 새로운 문자열 만들어서 반환 (원본에 변화 없음)
         */
        String str2 = "asdasdWERWERD123-.,24233ASDFsd";
        String str3 = str2.toLowerCase();
        String str4 = str2.toUpperCase();

        /*
            정규 표현식을 이용
         */
        String regExp = "\\s*[a-zA-Z]+";
        // 공백 0개 이상, 영문자 대소문 1개 이상

        String strTest = "a + b - c * d / e < f > g > = h < = i == j";
        String[] resStr = strTest.split(regExp);
        for(int i=0;i<resStr.length;i++){
            System.out.println(resStr[i]);
        }

        /*
            정규 표현식을 이용해서 숫자가 아닌 문자열을 제거
         */
        String str = "aaa1234, ^&*2233pp";
        String intStr = str.replaceAll("[^0-9]", "");
        System.out.println(intStr);
        // output: 12342233
    }
    public static void findAllRegEx(){
        String target = "나는 2008년도에 입학했다.";
        String regEx = "[0-9]";

        Pattern pat = Pattern.compile(regEx);
        Matcher match = pat.matcher(target);

        int matchCount = 0;
        while (match.find()) {
            System.out.println(matchCount + " : " + match.group());
            matchCount++;
        }
        System.out.println("총 개수 : " + matchCount);

        // 0 : 2
        // 1 : 0
        // 2 : 0
        // 3 : 8
        // 총 개수 : 4
    }
}
