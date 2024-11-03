import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<completion.length; i++){
            String cur = completion[i];
            if(map.get(cur)==null){
                map.put(cur,1);
            }else{
                int n = map.get(cur) + 1;
                map.put(cur,n);
            }
        }
        
        
        for(int i=0; i<participant.length; i++){
            String cur = participant[i];
            if(map.get(cur)==null){
                answer = cur;
                break;
            }else{
                if(map.get(cur)==0){
                    answer = cur;
                    break;
                }else{
                    int n = map.get(cur) - 1;
                    map.put(cur,n);
                }
            }
        }
        
        return answer;
    }
}