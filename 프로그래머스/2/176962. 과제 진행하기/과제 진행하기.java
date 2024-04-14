import java.util.*;

class Solution {
    
    // 시간 순 정렬 하고
    // korean 11:40 -> 30min
    // eng 12:10 -> 20min
    // math 12:30 -> 
    
    // music 12:20 -> 10min -> +40분
    // computer 12:30 -> 10min -> +90분
    // science 12:40 -> 80min -> -30분
    // history 14:00 ->
    
    public  ArrayList<String> solution(String[][] plans) {

        ArrayList<String> answer = new ArrayList<>();
        Deque<String> remains = new ArrayDeque<>();
        Deque<Integer> remainTimes = new ArrayDeque<>();
        
        Arrays.sort(plans, new Comparator<String[]>() {		
            @Override
            public int compare(String[] o1, String[] o2) {
                    return o1[1].toString().compareTo(o2[1].toString());         
            }			
        });
        
      
        
        for(int i=0; i<plans.length-1; i++){
            
            String min = plans[i][1].substring(3,5);
            int minute = Integer.parseInt(min);
            int hour = Integer.parseInt(plans[i][1].substring(0,2));
            
            int nextMin = Integer.parseInt(plans[i+1][1].substring(3,5));
            int nextHour = Integer.parseInt(plans[i+1][1].substring(0,2));
            
            int resMin = nextMin - minute;
            int resHour = nextHour - hour;

            // 다음시작 시간 까지 남은 시간
            int resTime = resMin + resHour*60;
            
            
            // 다음 시작 까지 남은 시간이 내가 필요한 시간보다 적다면 ..
            if(resTime < Integer.parseInt(plans[i][2])){
                int remainTime = resTime - Integer.parseInt(plans[i][2]);
                
                // 과목 이름 , 더 해야할 시간 추가
                remains.offerFirst(plans[i][0]);
                remainTimes.offerFirst(remainTime);
            }else{
            // 다음 시작 까지 남은 시간 동안 내가 필요한거 다 하고 남으면 ..
                answer.add(plans[i][0]);
                
                if(resTime > Integer.parseInt(plans[i][2])){
                    int haveTime = resTime - Integer.parseInt(plans[i][2]);
                    
                    // 내꺼 다하고 남은 시간 -> haveTime
                    
                    
                    //System.out.println(haveTime);
                    while(haveTime >= 0 && !remains.isEmpty()){
                         if(remainTimes.peek()+haveTime >= 0){
                            haveTime += remainTimes.peek();
                            System.out.println(haveTime);

                            remainTimes.pollFirst();
                            answer.add(remains.pollFirst());
                        }else{
                            //haveTime += remainTimes.peek();
                            int rTime = remainTimes.pollFirst();
                            remainTimes.addFirst(rTime+haveTime);
                            haveTime = -1;
                        }
                    }
                   

                }
            }
            
        }
        
        
        answer.add(plans[plans.length-1][0]);
        
        while(!remains.isEmpty()){
            answer.add(remains.pollFirst());
        }
        
        
        return answer;

    }
}