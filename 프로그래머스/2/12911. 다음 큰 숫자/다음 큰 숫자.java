class Solution {
    public int solution(int n) {
        int cnt = 0; 
        // 러프하게 간다 ?
        String binary = Integer.toBinaryString(n);
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i)=='1'){
                cnt ++;
            }
        }
        
        int start = n+1;
        
        while(true){
            int targetCnt = 0;
            String bin = Integer.toBinaryString(start);
            for(int i=0; i<bin.length(); i++){
                if(bin.charAt(i)=='1'){
                    targetCnt ++;
                }
            }
            
            if(targetCnt == cnt){
                break;
            }else{
                start++;
            }
        }
        
         
        return start;
    }
}