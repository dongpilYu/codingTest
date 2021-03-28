import java.util.*;


/*
    프로그래머스 레벌3 > 해시
    https://programmers.co.kr/learn/courses/30/lessons/42579
 */
public class hash_4 {
    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] arr = solution(genres, plays);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, ArrayList<Pair>> map1 = new HashMap<String, ArrayList<Pair>>();
        for(int i=0;i<genres.length;i++){

            Pair p = new Pair(plays[i], i);
            ArrayList<Pair> arr = new ArrayList<Pair>();
            arr.add(p);

            // map1.put(genres[i],map1.getOrDefault(genres[i], arr).add(p));
            if(map1.containsKey(genres[i])){
                ArrayList ar = map1.get(genres[i]);
                ar.add(p);
                map1.put(genres[i], ar);
            }else{
                map1.put(genres[i], arr);
            }
        }
        for(Map.Entry<String, ArrayList<Pair>> entry : map1.entrySet()){
            Collections.sort(entry.getValue(), new PairComparator());
        }

        List<Map.Entry<String, ArrayList<Pair>>> list_entries = new ArrayList<Map.Entry<String, ArrayList<Pair>>>(map1.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<String, ArrayList<Pair>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<Pair>> o1, Map.Entry<String, ArrayList<Pair>> o2) {

                int sum1 = 0, sum2 = 0;
                for(int j=0;j<o1.getValue().size();j++){
                    sum1 += o1.getValue().indexOf(j);
                }
                for(int j=0;j<o1.getValue().size();j++){
                    sum2 += o1.getValue().indexOf(j);
                }
                if(sum1 > sum2)
                    return 1;
                else if(sum1 < sum2)
                    return -1;
                else
                    return 0;
            }
        });

        for(Map.Entry<String, ArrayList<Pair>> entry : map1.entrySet()){
            System.out.println("key: " + entry.getKey());
            for(int j=0;j<entry.getValue().size();j++)
                System.out.println("first: " + entry.getValue().get(j).first() + " second: " + entry.getValue().get(j).second());
        }


        return answer;
    }
}
class Pair{
    Integer x;
    Integer y;
    public Pair(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
    public Integer first(){
        return x;
    }
    public Integer second(){
        return y;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b){
        if(a.first() > b.first())
            return -1;
        else if(a.first() < b.first())
            return 1;

        return 0;
    }
}
