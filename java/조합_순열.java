import java.util.ArrayList;

public class 조합_순열 {
    public static void main(String[] args){

        String str = "ABCDEFG";
        int r = 4;
        char[] answer_perm = new char[r];
        ArrayList<Character> answer_comb = new ArrayList<>();
        int[] visited = new int[str.length()];
        combination(str.toCharArray(), answer_comb, 0, 4);
        permutation(str.toCharArray(), answer_perm, visited);

    }
    public static void permutation(char[] str, char[] answer, int[] visited){

    }
    public static void combination(char[] str, ArrayList<Character> answer, int idx, int num){
        /*
            str : 입력 문자열, 불변
            answer : 정답 문자열, 가변
            idx : str의 인덱스, 조합은 이전 요소가 포함되면 안되기 떄문에 둠, 0 -> str.length
            num : 몇 개가 포함되었는지를 나타내는 변수, num == 0 이면 종료, r -> 0
         */

        if(num == 0){
            System.out.println(answer.toString());
        }

        for(int i=idx;i<str.length;i++){
            // answer에 값을 채울 인덱스 변수를 두거나,
            // arrayList 등으로 인덱스가 아니여도 값을 채울 수 있도록
            // answer.add(str[idx]);
            // String 처럼 불변으로 보내고 땡이였으면 좋겠는데, 레퍼런스를 전달하기 때문에 연결됨
            combination(str, answer, i+1, num-1);

        }



    }
}
