class Solution {
    static int[] num;
    static int goal;
    static int cnt = 0; // return 해야하는 ans
    
    public static int solution(int[] numbers, int target) {
        num = numbers;
        goal = target;
        simul(0,0,0);

        return cnt;
    }
    
    private static void simul(int start, int res, int cur) {
        // 시도 횟수 , 현재 수식 완료 수 , 지금 지켜보고 있는 수 위



        if(start == num.length){ // 4
            if(res == goal) cnt++;
            return;
        }

        for(int i=0; i<2; i++){
            if(i==0){
                res += num[cur];
                simul(start+1, res, cur+1);
                res -= num[cur];
            }else{
                res -= num[cur];
                simul(start+1, res, cur+1);
                res += num[cur];
            }
        }

        

    }
}