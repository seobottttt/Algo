import java.util.*;

class Solution {
    
    static String goal;
    static String[] wordArr;
    
    // 비교 함수
    public boolean compString(String s1, String s2){
        int cnt = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)) cnt++;
        }
        
        if(cnt==1) return true;
        else return false;
    }
    
    static Queue<Integer> q = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;
    static int[] cnt;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int min = 100;
        
        goal = target;
        wordArr = words.clone();
        
        // 처음으로 가능한 출발지 저장
        for(int i=0; i<words.length; i++){
            String cur = words[i];
            if(compString(begin, cur)){
                list.add(i);
                System.out.println(i);
            }
        }
        
        if(list.isEmpty()) return 0;
        
        for(int i=0; i<list.size(); i++){
            System.out.println("??" + list.get(i));

            visited = new boolean[wordArr.length];
            cnt = new int[wordArr.length];
            int res = BFS(list.get(i));
            min = Math.min(min,res);
            q.clear();
        }
        
        if(min==100) return 0;
        
        answer = min;
        return answer;
    }
    
    public int BFS(int idx){
        visited[idx] = true; 
        cnt[idx] = 1;

        if(goal.equals(wordArr[idx])) return 1;
        
        q.add(idx);
        
        while(!q.isEmpty()){
            
            int curIdx = q.peek();
            q.poll();
            
            if(goal.equals(wordArr[curIdx])){
                return cnt[curIdx];
            }
            
            for(int i=0; i<wordArr.length; i++){
                if(i==curIdx) continue;
                if(!visited[i] && compString(wordArr[curIdx],wordArr[i])){
                    q.add(i);
                    visited[i] = true;
                    cnt[i] = cnt[curIdx]+1;
                }
            }
        }
        
        return 100;
        
    }
}