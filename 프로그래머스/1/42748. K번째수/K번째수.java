import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<commands.length; i++){
            
            int start = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];
            int len = end-start+1;
            
            int[] curArr = new int[len];
            System.arraycopy(array,start-1,curArr,0,len);
            
            
            Arrays.sort(curArr);
            
            
            int ans = curArr[target-1];
            answer.add(ans);
            
            
            
        }
        
        
        
        return answer;
    }
}