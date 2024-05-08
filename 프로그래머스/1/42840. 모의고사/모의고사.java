import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> points = new ArrayList<Integer>();

        // 1번 12345 5주기
        // 2번 21232425 8주기
        // 3번 3311224455 10주기
        int[] oneAns = new int[] {1,2,3,4,5};
        int[] twoAns = new int[] {2,1,2,3,2,4,2,5};
        int[] threeAns = new int[] {3,3,1,1,2,2,4,4,5,5};
        
        int one = 0;
        int two = 0;
        int three = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i]==oneAns[i%5]) one++;
            if(answers[i]==twoAns[i%8]) two++;
            if(answers[i]==threeAns[i%10]) three++;
        }
        
        int max = 0;
        
        points.add(one);
        points.add(two);
        points.add(three);
        
        Collections.sort(points);
        
        if(points.get(2)==one){
            answer.add(1);
        }if(points.get(2)==two){
            answer.add(2);
        }if(points.get(2)==three){
            answer.add(3);
        }

        
        
    
       
        
        return answer;
    }
}