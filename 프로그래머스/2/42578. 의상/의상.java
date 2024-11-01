// [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
// 5가지 리턴함

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
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
        
        
        Set<String> keySet = map.keySet();
        if(map.size()==1){
            answer = clothes.length;
        }else{
            int val = 1;
            for (String k:keySet){
                val *= map.get(k);
            }
            answer += clothes.length;
            answer += val;
        }
        
        
        return answer;
    }
}