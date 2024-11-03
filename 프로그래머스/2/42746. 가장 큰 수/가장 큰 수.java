import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            String cur = numbers[i] + "";
            nums[i] = cur;
        }
        
        Arrays.sort(nums,(s1,s2)->(s2+s1).compareTo(s1+s2));
        
        if(nums[0].equals("0")) return "0";
        
        for(String s : nums){
            answer += s;
        }
        
        
        return answer;
    }
}