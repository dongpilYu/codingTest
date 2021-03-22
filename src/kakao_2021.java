import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class kakao_2021 {
    public static void main(String[] args){
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] an = kakao_2021.solution(info, query);
        for(int i=0;i<an.length;i++)
            System.out.print(an[i] + " ");
    }
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
         /*
            모든 경우를 상수화 (108 case)
            query에 해당하는 케이스를 하나의 배열에서 찾기 위해 -를 고려해서 만
         */
        int lang_none = 0, cpp = 27, java = 54, python = 81;
        int pos_none = 0, backend = 9, frontend = 18;
        int tmp_none = 0, junior= 3, senior = 6;
        int food_none = 0, chicken = 1, pizza = 2;

        ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<108;i++){
            ArrayList<Integer> data0 =  new ArrayList<Integer>();
            data.add(data0);
        }

         /*

         1. 맵 생성 : length
         2. 정렬 : n log n
         3. 탐색 : query

         */
        int num =0;
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

            //.println(num_list[0] + "," + num_list[1] + "," + num_list[2] + "," + num_list[3]);
            // 0, 전체
            data.get(0).add(Integer.parseInt(r2[4]));
            data.get(num_list[0] + num_list[1] + num_list[2] + num_list[3]).add(Integer.parseInt(r2[4]));

            // 1개 선택
            for(int idx0=0;idx0<4;idx0++){
                data.get(num_list[idx0]).add(Integer.parseInt(r2[4]));
            }
            for(int idx0=0;idx0<4;idx0++){
                for(int idx1=idx0+1;idx1<4;idx1++){
                    data.get(num_list[idx0] + num_list[idx1]).add(Integer.parseInt(r2[4]));
                }
            }
            for(int idx0=0;idx0<4;idx0++){
                for(int idx1=idx0+1;idx1<4;idx1++){
                    for(int idx2=idx1+1;idx2<4;idx2++) {
                        data.get(num_list[idx0] + num_list[idx1] + num_list[idx2]).add(Integer.parseInt(r2[4]));
                    }
                }
            }

        }

        for(int i=0;i<108;i++){
            //System.out.println(i + "번 째" + data.get(i));
            Collections.sort(data.get(i));
        }

        //String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        //System.out.println(query[0].replace(" and ", " ").replace("\"", ""));

        ArrayList<Integer> output = new ArrayList<Integer>();

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

            int num2 = num_list[0] + num_list[1] + num_list[2] + num_list[3];
            int idx = LowerBound(data.get(num2), Integer.parseInt(r2[4]));

            // 10, 20, 20, 30, 40

            // output.add(data.get(num2).size() - idx);
            // System.out.print((data.get(num2).size() - idx) + " ");
            answer[i] = data.get(num2).size() - idx;

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