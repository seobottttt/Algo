import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        
        List<Integer> answer = new ArrayList<>();
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i=0; i<arr.length; i++){
            int cur = arr[i];
            if(deque.size()==0){
                deque.addLast(cur);
            }else{
                if(deque.peekLast()==cur){
                    continue;
                }
                else{
                    deque.addLast(cur);
                }
            }
        }
        
        int size = deque.size();
        
        for(int i=0; i<size; i++){
            int ans = deque.poll();
            answer.add(ans);
        }
     

        return answer;
        
    }
}