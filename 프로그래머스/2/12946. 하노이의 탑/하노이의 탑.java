import java.util.*;

class Solution {
    public static List<int[]> answer = new ArrayList<>();

    public List<int[]> solution(int n) {
        hanoi(n,1,3,2);
        return answer;
    }
    
    public static void hanoi(int n, int start, int to, int mid) {
        int[] move = {start,to};
        
        if(n==1){
            answer.add(move);
            return;
        }
        
        hanoi(n-1, start, mid, to);
        answer.add(move);
        hanoi(n-1, mid, to, start);
    }
}