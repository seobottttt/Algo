class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String str = Integer.toString(x);
        int res = 0;
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            int cur = c - '0';
            res+= cur;
        }
        
        if(x % res != 0){
            answer = false;
            return answer;
        }
        
        return answer;
    }
}