class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int len = land.length;
        
        //System.out.println(len);
        
        int[][] DP = new int[len][4];
        
        for(int i=0; i<len; i++){
            for(int j=0; j<4; j++){
                DP[i][j] = land[i][j];
            }
        }
        
        for(int i=1; i<len; i++){
            for(int j=0; j<4; j++){
                if(j==0){
                    DP[i][j] = Math.max(DP[i][j]+DP[i-1][1],DP[i][j]+DP[i-1][2]);
                    DP[i][j] = Math.max(DP[i][j],land[i][j]+DP[i-1][3]);
                }
                if(j==1){
                    DP[i][j] = Math.max(DP[i][j]+DP[i-1][0],DP[i][j]+DP[i-1][2]);
                    DP[i][j] = Math.max(DP[i][j],land[i][j]+DP[i-1][3]);
                }
                if(j==2){
                    DP[i][j] = Math.max(DP[i][j]+DP[i-1][0],DP[i][j]+DP[i-1][1]);
                    DP[i][j] = Math.max(DP[i][j],land[i][j]+DP[i-1][3]);
                }
                if(j==3){
                    DP[i][j] = Math.max(DP[i][j]+DP[i-1][0],DP[i][j]+DP[i-1][1]);
                    DP[i][j] = Math.max(DP[i][j],land[i][j]+DP[i-1][2]);
                }
                // System.out.println(i);
                // System.out.println(j);
                // System.out.println(DP[i][j]);
                // System.out.println();


            }
        }
        
        for(int i=0; i<4; i++){
            answer = Math.max(DP[len-1][i],answer);
        }

        
        return answer;
    }
}