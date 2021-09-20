
public class dp_등굣길 {

    public static void main(String[] args){

        int[][] paddles = {{2,2}, {1,5}, {3,4}, {4,2}};
        // System.out.println(paddles.length);
        int ans = dp_등굣길.solution(6, 4, paddles);
        System.out.println(ans);
    }

    public static int solution(int m, int n, int[][] paddles){
        int answer = 0;
        int[][] map = new int[n][m];

        for(int i=0;i<paddles.length;i++)
            map[paddles[i][1] - 1][paddles[i][0] - 1] = -1;

        boolean isBlocked = false;
        for(int i=0;i<m;i++){
            if(map[0][i] == 0) {
                if(isBlocked == true)
                    map[0][i] = 0;
                else
                    map[0][i] = 1;
            }
            else if(map[0][i] == -1)
                isBlocked = true;
        }
        isBlocked = false;
        for(int j=0;j<n;j++){
            if(map[j][0] == 0) {
                if(isBlocked == true)
                    map[j][0] = 0;
                else
                    map[j][0] = 1;
            }
            else if(map[j][0] == -1)
                isBlocked = true;
        }
        /*
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
        */
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(map[i][j] == 0){
                    if(map[i-1][j] == -1 && map[i][j-1] == -1){
                        continue;
                    }
                    if(map[i-1][j] == -1){
                        map[i][j] = map[i][j-1];
                    }else if(map[i][j-1] == -1){
                        map[i][j] = map[i-1][j];
                    }else{
                        map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
                    }
                }else if(map[i][j] == -1){
                    continue;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                System.out.print(map[i][j]);
            System.out.println();
        }

        answer = map[n-1][m-1] ;
        return answer;
    }
}
