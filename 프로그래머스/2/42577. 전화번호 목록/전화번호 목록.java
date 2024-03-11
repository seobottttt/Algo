import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> phone_nums = new HashSet<>();
        
        for(int i=0; i<phone_book.length; i++){
            phone_nums.add(phone_book[i]);
        }
        
        for(int i=0; i<phone_book.length; i++){
            String cur = phone_book[i];
            for(int j=1; j<cur.length(); j++){
                if(phone_nums.contains(cur.substring(0,j))){
                    answer = false;
                    return answer;
                }
            }
        }
        
        
        return answer;
    }
}