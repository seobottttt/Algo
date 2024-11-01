import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int maxNum = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        if(set.size() >= maxNum){
            answer = maxNum;
        }else{
            answer = set.size();
        }
        
        return answer;
    }
}