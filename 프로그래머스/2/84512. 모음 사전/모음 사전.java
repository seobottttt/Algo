class Solution {
    
    static char[] arr = {'A','E','I','O','U'};
    static int cnt = 0;
    static int answer = 0;
    
    public int solution(String word) {
        
        // 백트래킹
        // A 
        // AA 
        // AAA 
        // AAAA AAAAA AAAAE AAAAI AAAAO AAAAU
        // AAAE AAAEA AAAEE AAAEI AAAEO AAAEU 
        // AAAI AAAIA AAAIE AAAII AAAIO AAAIU
        // ..
        Search(word, "");
        
        
        return answer;
        
    }
    
    static void Search(String word, String cur){
        if(word.equals(cur)){
            answer = cnt;
            return;
        }else{
            
            if(cur.length() == 5){
                return; 
            }
            
            for(int i=0; i<5; i++){
                cur += arr[i];
                cnt++;
                Search(word, cur);
                cur = cur.substring(0,cur.length()-1);
            }
        }
    }
}