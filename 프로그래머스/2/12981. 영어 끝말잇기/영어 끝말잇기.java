import java.util.*;

// 1. 말했던 단어인지
// 2. 첫글자가 틀렸는지
class Solution {
    public List<Integer> solution(int n, String[] words) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String,Integer> map = new HashMap<>();
        int turn = 0;
        char startChar = words[0].charAt(0);
        
        for(int i=0; i<words.length; i++){
            if((i+1)%n==1) turn ++;
            int playerNum = (i+1)%n==0 ? n : (i+1)%n;
            
            String cur = words[i];
            if(map.get(cur)!=null){
                //탈락
                answer.add(playerNum);
                answer.add(turn);
                break;
                
            }else{
                if(startChar!=cur.charAt(0)){
                    answer.add(playerNum);
                    answer.add(turn);
                    break;
                }
                else{
                    map.put(cur,1);
                    startChar = cur.charAt(cur.length()-1);
                }
               
            }
        }
        
        if(answer.isEmpty()){
            answer.add(0);
            answer.add(0);
        }

        return answer;
    }
}