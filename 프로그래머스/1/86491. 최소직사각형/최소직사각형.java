class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxWidth = sizes[0][0];
        int maxHeight = sizes[0][1];
        
        if(sizes.length == 1){
            return maxWidth * maxHeight;
        }
        
        for(int i=1; i<sizes.length; i++){
            
            int curWidth = maxWidth;
            int curHeight = maxHeight;
            
            if(sizes[i][0]>curWidth) curWidth = sizes[i][0];
            if(sizes[i][1]>curHeight) curHeight = sizes[i][1];
            
            int curSize = curWidth * curHeight;
            
            int rotateWidth = maxWidth;
            int rotateHeight = maxHeight;
            
            if(sizes[i][1]>rotateWidth) rotateWidth=sizes[i][1];
            if(sizes[i][0]>rotateHeight) rotateHeight=sizes[i][0];
            
            int rotateSize = rotateWidth * rotateHeight;
            
            if(curSize>rotateSize){
                maxWidth = rotateWidth;
                maxHeight = rotateHeight;
                answer = rotateSize;
            }else{
                maxWidth = curWidth;
                maxHeight = curHeight;
                answer = curSize;
            }
                
            
        }
        
        return answer;
    }
}