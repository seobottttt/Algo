import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String,Integer> mostGen = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            String curGen = genres[i];
            int curPlay = plays[i];
            
            if(mostGen.get(curGen)==null){
                mostGen.put(curGen,curPlay);
            }else{
                int n = mostGen.get(curGen) + curPlay;
                mostGen.put(curGen,n);
            }
        }
        
        List<String> keySet = new ArrayList<>(mostGen.keySet());
        keySet.sort((o1, o2) -> mostGen.get(o2).compareTo(mostGen.get(o1)));
        
        
        for(String k : keySet){
            // 지금 k에 대해 최대 두개씩 집어 넣을 것임            
            HashMap<Integer,Integer> map = new HashMap<>();
            
            for(int i=0; i<genres.length; i++){
                String curGen = genres[i];
                int curPlay = plays[i];
                
                if(curGen.equals(k)){
                    map.put(i,curPlay);
                }   
            }
            
            List<Integer> keySet2 = new ArrayList<>(map.keySet());
            keySet2.sort((o1, o2) -> {
                int compareValue = map.get(o2).compareTo(map.get(o1));
                if (compareValue == 0) {
                    return o1.compareTo(o2); // 값이 같을 경우 키로 정렬
                }
                return compareValue;
            }); 
            
            for(int i=0; i<keySet2.size(); i++){
                if(i==2) break;
                else {
                    answer.add(keySet2.get(i));
                }
            }
            
            
            

        }
        
       
        
        
        return answer;
        
        
    }
}