class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] std = new int[n];
        
        for(int i=0; i<std.length; i++){
            std[i] = 1;
        }
        
        for(int i=0; i<reserve.length; i++){
            std[reserve[i]-1]=2;
        }
        for(int i=0; i<lost.length; i++){
            std[lost[i]-1]-=1;
        }
        
        for(int i=0; i<std.length-1; i++){
            if(i==0){
                if(std[i]==2 && std[i+1]==0){
                    std[i]-=1;
                    std[i+1]+=1;
                }
            }else{
                if(std[i]==2 && std[i-1]==0){
                    std[i]-=1;
                    std[i-1]+=1;
                }else if(std[i]==2 && std[i+1]==0){
                    std[i]-=1;
                    std[i+1] +=1;
                }
            }
        }
        
        if(std[std.length-1]==2 && std[std.length-2]==0){
            std[std.length-1]-=1;
            std[std.length-2]+=1;
        }
        
        for(int i=0; i<std.length; i++){
            if(std[i]==1||std[i]==2) answer++;
        }
        
        
        return answer;
    }
}