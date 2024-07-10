import java.util.*;

class Solution {
    public List<List<Integer>> solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        
        int a = arr1.length;
        int b = arr1[0].length;

        System.out.println(a);
        System.out.println(b);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<arr1.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<arr1[0].length; j++){
                int num = arr1[i][j] + arr2[i][j];
                list.add(num);
            }
            ans.add(list);
        }

        return ans;
    }
}