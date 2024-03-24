import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int startRow = 50;
        int startCol = 50;
        int endRow = 0;
        int endCol = 0;
        
        for(int i=0; i<wallpaper.length; i++){
            String cur = wallpaper[i];
            for(int j=0; j<cur.length(); j++){
                char ch = cur.charAt(j);
                //System.out.println(ch);
                
                if(ch=='#'){
                   
                    if(endRow<i+1){
                        endRow = i+1;
                    }
                    if(endCol<j+1){
                        endCol = j+1;
                    }
                    
                    if(startRow>i-1){
                        startRow = i;
                    }
                    if(startCol>j-1){
                        startCol = j;
                    }
                    
                }
            }
        }
        
        answer[0] = startRow;
        answer[1] = startCol;
        answer[2] = endRow;
        answer[3] = endCol;
        
        
        return answer;
    }
}
//
//