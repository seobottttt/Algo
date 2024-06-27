class Solution {
    public int solution(int n) {
        int answer = 1;
        int ans = n;
        
        for(int i=2; i<=n; i++){
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i%j==0){
                    answer++;
                    break;
                }
            }
        } 
        
        return n-answer;
        
       
    }
}