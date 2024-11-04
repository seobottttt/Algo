import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        
        int[] first = new int[]{1,2,3,4,5};
        int[] second = new int[]{2,1,2,3,2,4,2,5};
        int[] third = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int one = 0;
        int two = 0;
        int three = 0;
        
        for(int i=0; i<answers.length; i++){
            int cur = answers[i];
            if(cur == first[i%5]) one ++;
            if(cur == second[i%8]) two++;
            if(cur == third[i%10]) three++;
        }
        
        int max = 0;
        max = Math.max(one,max);
        max = Math.max(two,max);
        max = Math.max(three,max);
        
        if(max == one) answer.add(1);
        if(max == two) answer.add(2);
        if(max == three) answer.add(3);
        
        
        return answer;
    }
}