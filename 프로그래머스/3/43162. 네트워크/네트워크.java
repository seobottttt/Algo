class Solution {
    // visited 배열 만들고 1차원 있으면 더 나아가라 , 그다음 끝나면 연결요소 개수 ++
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
           if(!visited[i]){
               answer++;
               dfs(i,computers,n);
           }
        }
        
        return answer;
    }
    
    public void dfs(int com, int[][] coms, int num){
        visited[com] = true;
        
         for(int i=0; i<num; i++){
             if(com!=i && coms[com][i]==1 && !visited[i]){
                 dfs(i,coms,num);
             }
         }
        
    }
}