/*
    2021 kakao blind test - 순위 검색
    https://programmers.co.kr/learn/courses/30/lessons/72412
 */
import java.util.ArrayList;
import java.util.Collections;

class 카카오_순위검색 {
    public static void main(String[] args){
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] an = 카카오_순위검색_2.solution(info, query);
        for(int i=0;i<an.length;i++)
            System.out.print(an[i] + "  ");
    }
    public static int[] solution(String[] info, String[] query) {

        int[] answer = new int[query.length];
        int lang_none = 0, cpp = 1, java = 2, python = 3;
        int pos_none = 0, backend = 1, frontend = 2;
        int tmp_none = 0, junior = 1, senior = 2;
        int food_none = 0, chicken = 1, pizza = 2;

        // 1차원이 아니라, 다차원으로 할 경우
        ArrayList<Integer>[][][][] data = new ArrayList[4][3][3][3];
        /*
        // 초기화 및 출력 예시
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        data2[i][j][k][l] = new ArrayList<Integer>();
                        int number = (int) (Math.random() * 4);
                        for (int q = 0; q < number; q++) {
                            data2[i][j][k][l].add((int) (Math.random()));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        System.out.printf("%d ", data2[i][j][k][l].size());
                    }
                    System.out.printf("\n");
                }
                System.out.printf("\n");
            }
            System.out.printf("\n");
        }
        */

         /*

         1. 맵 생성 : info length
         2. 정렬 : n log n (n은 각 인덱스에 할당된 리스트의 크기)
         3. 탐색 : query length

         */
        int[] num_list = {0,0,0,0};
        for(int i=0;i<info.length;i++){
            //System.out.println(info[i]);

            String[] r2 = info[i].split(" ");
            if(r2[0].equals("cpp"))
                num_list[0] = cpp;
            else if(r2[0].equals("python"))
                num_list[0] = python;
            else if(r2[0].equals("java"))
                num_list[0] = java;

            if(r2[1].equals("backend"))
                num_list[1] = backend;
            else if(r2[1].equals("frontend"))
                num_list[1] = frontend;

            if(r2[2].equals("junior"))
                num_list[2] = junior;
            else if(r2[2].equals("senior"))
                num_list[2] = senior;

            if(r2[3].equals("chicken"))
                num_list[3] = chicken;
            else
                num_list[3] = pizza;

            // 0, 전체
            data[0][0][0][0].add(Integer.parseInt(r2[4]));
            data[num_list[0]][num_list[1]][num_list[2]][num_list[3]].add(Integer.parseInt(r2[4]));

            // 1개를 0으로, 3개 선
            for(int idx0=0;idx0<4;idx0++){
                int a = num_list[idx0];
                num_list[idx0] = 0;
                data[num_list[0]][num_list[1]][num_list[2]][num_list[3]].add(Integer.parseInt(r2[4]));
                num_list[idx0] = a;
            }
            // 2개 선택
            for(int idx0=0;idx0<4;idx0++){
                for(int idx1=idx0+1;idx1<4;idx1++){
                    // data.get(num_list[idx0] + num_list[idx1]).add(Integer.parseInt(r2[4]));
                    int a = num_list[idx0];
                    int b = num_list[idx1];
                    num_list[idx0] = 0;
                    num_list[idx1] = 0;
                    data[num_list[0]][num_list[1]][num_list[2]][num_list[3]].add(Integer.parseInt(r2[4]));
                    num_list[idx0] = a;
                    num_list[idx1] = b;

                }
            }
            // 1개 선택
            for(int idx0=0;idx0<4;idx0++){
                for(int idx1=idx0+1;idx1<4;idx1++){
                    for(int idx2=idx1+1;idx2<4;idx2++) {
                        int a = num_list[idx0];
                        int b = num_list[idx1];
                        int c = num_list[idx2];
                        num_list[idx0] = 0;
                        num_list[idx1] = 0;
                        num_list[idx2] = 0;
                        data[num_list[0]][num_list[1]][num_list[2]][num_list[3]].add(Integer.parseInt(r2[4]));
                        num_list[idx0] = a;
                        num_list[idx1] = b;
                        num_list[idx2] = c;
                    }
                }
            }

        }

        //  정
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        Collections.sort(data[i][j][k][l]);
                    }
                }
            }

        }
        for(int i=0;i<query.length;i++){

            String[] r2 = query[i].replace("\"", "").replace(" and ", " ").split(" ");

            if(r2[0].equals("cpp"))
                num_list[0] = cpp;
            else if(r2[0].equals("python"))
                num_list[0] = python;
            else if(r2[0].equals("java"))
                num_list[0] = java;
            else
                num_list[0] = lang_none;

            if(r2[1].equals("backend"))
                num_list[1] = backend;
            else if(r2[1].equals("frontend"))
                num_list[1] = frontend;
            else
                num_list[1] = pos_none;

            if(r2[2].equals("junior"))
                num_list[2] = junior;
            else if(r2[2].equals("senior"))
                num_list[2] = senior;
            else
                num_list[2] = tmp_none;

            if(r2[3].equals("chicken"))
                num_list[3] = chicken;
            else if(r2[3].equals("pizza"))
                num_list[3] = pizza;
            else
                num_list[3] = food_none;
            int idx = LowerBound(data[num_list[0]][num_list[1]][num_list[2]][num_list[3]], Integer.parseInt(r2[4]));

            answer[i] = data[num_list[0]][num_list[1]][num_list[2]][num_list[3]].size() - idx;

        }
        return answer;
    }
    static int LowerBound(ArrayList<Integer> a, int x) { // x is the target value or key
        int l=-1,r=a.size();
        while(l+1<r) {
            int m=(l+r)>>>1;
            if(a.get(m)>=x) r=m;
            else l=m;
        }
        return r;
    }
}