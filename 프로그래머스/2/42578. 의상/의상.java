// [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
// 5가지 리턴함

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String curKind = clothes[i][1];
            if(map.get(curKind)==null){
                map.put(curKind,1);
            }else{
                int num = map.get(curKind);
                map.put(curKind, num+1);
            }
        }
        
        Set<String> set = map.keySet();
        if(map.size()==1){
            answer = clothes.length;
        }else{
            for(String k : set){
                int curVal = map.get(k);
                answer *= curVal + 1;
            }
            answer -= 1;
        }
        
        
        return answer;
    }
}