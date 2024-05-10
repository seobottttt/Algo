import java.util.*;

class Solution {
    
    char[] nums = null;
    HashSet<Integer> set = new HashSet<>();
    static boolean[] visited = new boolean[7]; // numbers는 길이 1 이상 7 이하인 문자열

    
    public int solution(String numbers) {
        int answer = 0;
        
        nums = new char[numbers.length()];
        
        for(int i=0; i< numbers.length(); i++){
            char cur = numbers.charAt(i);
            nums[i] = cur;
        }
        
        makeNumber(numbers,"",0);
        
        for(int n : set){
            if(isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    public void makeNumber(String numbers,String s,int depth){
        
        if(depth==numbers.length()){
            return;
        }
        
        
        
        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                makeNumber(numbers ,s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
        
        
        
        
        
        
        
    }
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
		// 에라토스테네스 체
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
 
        return true;
    }
}