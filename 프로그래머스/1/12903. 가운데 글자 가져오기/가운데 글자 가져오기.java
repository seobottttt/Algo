class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int point;
        
        if(len%2==0){
            point = len/2;
            sb.append(s.charAt(point-1));
            sb.append(s.charAt(point));
            
        }else{
            point = len/2+1;
            sb.append(s.charAt(point-1));
        }
        
        
        answer = sb.toString();
        return answer;
    }
}