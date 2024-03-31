import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            //arr[i] = numbers[i].toString();
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (s1,s2)->(s2+s1).compareTo(s1+s2));
        
        if(arr[0].equals("0")){
            return "0";
        }
        
        StringBuilder ans = new StringBuilder();
        
        // for(int i=0; i<arr.length; i++){
        //     ans.append(arr[i]);
        // }
        
        for(String s : arr){
            ans.append(s);
        }
        
        
        return ans.toString();
    }
}