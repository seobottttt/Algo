import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<phone_book.length; i++){
            String curNum = phone_book[i];
            set.add(curNum);
        }
       
        for(int i=0; i<phone_book.length; i++){
            String curNum = phone_book[i];
            
            for(int j=1; j<curNum.length(); j++){
                if(set.contains(curNum.substring(0,j))){
                    answer=false;
                    return answer;
                }
            }
        }
        
        
        return answer;
    }
}