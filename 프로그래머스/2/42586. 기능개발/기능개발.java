import java.util.*;

class Solution {
    // 95 90 99 99 80 99
    // 5일 10일 1일 1일 20일 1일
    
    // 93 30 55
    // 7일 3일 9일
    
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int[] remain = new int[progresses.length];
        
        for(int i=0; i<progresses.length; i++){
            int cur = 100 - progresses[i];
            int day = 0;
            while(cur > 0){
                cur -= speeds[i];
                day++;
            }
            remain[i] = day;
        }
        
        int start = 0;
        int cnt = 1;
        for(int i=1; i<progresses.length; i++){
            
            if(i<start) continue;
            
            if(remain[start]>=remain[i]){
                cnt++;
            }else{
                start = i;
                answer.add(cnt);
                cnt = 1;
            }
            
            
        }
        answer.add(cnt);
        
        
        
        return answer;
    }
}