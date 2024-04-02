import java.util.*;

class Solution {
    // AC CDE ACDE BCFG ABCFG ACDEH 2,3,4
    
    // AC - CD CE - AC AD AE CD CE DE - BC BF BG CF CG FG
    // AB AC AG AG BC BG BG CF CG FG - AC AD AE AH CD CE CH DE DH EH
    
    // course에 주어진 갯수 대로 .. 하나씩 진행한다 .. ?
    // 2개 -> 3개 -> 4개 이런식 ?
    
    // 우선 완탐으로 해보자  -> 다른 거 생각 안남
    
    // 각 문자열 정렬 시킨다 알파벳으로
    static Map<String,Integer> menu = new HashMap<>();  
    static int max = 0;

    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<orders.length; i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = new String(charArr);
        }
         for(String s : orders){
            System.out.println(s);
        }
        
        for (int num : course){
            for(String s : orders){
                CreateMenu(s,num,"",0);      
            }
            for(String k : menu.keySet()){
                    if(menu.get(k)==max && max!=1){
                        answer.add(k);
                    }
            }
            
            // for(String k : menu.keySet()){
            //     System.out.println(num+" "+k + " " + menu.get(k));
            // }   
            
            max = 0;
            menu.clear();
            
        }
        
        
        Collections.sort(answer);
        
        return answer;
    }
    
    public static void CreateMenu(String s, int curNum, String make, int cnt){
        
       // System.out.println("s : "+ s + " " + make + " " + cnt);
        
        if(make.length()>curNum) return;
        if(make.length()==curNum){
            if(menu.get(make)==null){
                menu.put(make,1);
                if(menu.get(make)>max){
                    max = menu.get(make);
                }
            }else{
                menu.put(make,menu.get(make)+1);
               if(menu.get(make)>max){
                    max = menu.get(make);
                }
            }
            return;
        }
        
        // X : 1
        // XY : 2
        // X : 2
        // XZ : 3
        for(int i=cnt; i<s.length(); i++){
            make += s.charAt(i);
            cnt++;
            CreateMenu(s, curNum, make, cnt);
            make = make.substring(0,make.length()-1);
        }
        
    }
}