class Solution {
    
    static int ans;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return ans;
    }
    
    static public void dfs(int cnt, int k, int[][] dungeons){
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] || dungeons[i][0] > k) continue;
            visited[i] = true;
            dfs(cnt + 1, k-dungeons[i][1], dungeons);
            visited[i] = false;
        }
        
        ans = Math.max(ans,cnt);
    }
}