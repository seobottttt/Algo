import java.util.*;

class Solution {
    
    // 기준 : ext
    // 기준 값 : val_ext : 기준값 보다 적은 것들을
    // 정렬 기준 : sort_by : 이걸로 적은것
    
    // code , date , maximum , remain
    
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        int sortNum;
         if(sort_by.equals("code")){
            sortNum = 0;
         }else if(sort_by.equals("date")){
            sortNum = 1;    
         }else if(sort_by.equals("maximum")){
             sortNum = 2;
         }else{
             sortNum = 3;
         }
        
        List<int[]> ansList  = new ArrayList<>();
                    
        
        if(ext.equals("code")){
            for(int i=0; i<data.length; i++){
                int curCode = data[i][0];
                if(curCode<val_ext){  
                  ansList.add(data[i]);           
                }
            }
            
                 
        }else if(ext.equals("date")){
            for(int i=0; i<data.length; i++){
                int curDate = data[i][1];
                if(curDate<val_ext){  
                     ansList.add(data[i]);
                }
            }
            
            
        }else if(ext.equals("maximum")){
            for(int i=0; i<data.length; i++){
                int curMax = data[i][2];
                if(curMax<val_ext){
                  ansList.add(data[i]);
                }
            }
            
        }else{
            for(int i=0; i<data.length; i++){
                int curRemain = data[i][3];
                if(curRemain<val_ext){
                     ansList.add(data[i]);
                }
            }
        }
        
        Collections.sort(ansList,(s1,s2)->s1[sortNum]-s2[sortNum]);
        
        return ansList;
        
    }
}