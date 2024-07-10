import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        char[] alpha = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            alpha[i] = cur;
        }
        
        Arrays.sort(alpha);
        
        for(int i=s.length()-1; i>=0; i--){
            sb.append(alpha[i]);
        }
        
        return sb.toString();
    }
}