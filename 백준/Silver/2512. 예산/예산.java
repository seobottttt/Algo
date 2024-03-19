import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int curSum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int cur = Integer.parseInt(st.nextToken());
            curSum+=cur;
            arr[i] = cur;
        }
        Arrays.sort(arr);

        int target = Integer.parseInt(br.readLine());

        int start = 0;
        int end = arr[n-1];
        int answer = 0;

        if(curSum<=target){
            System.out.println(end);
        }else{
            while (start <= end) {
                int mid = (start + end) / 2;
                int sum = 0;
                for (int value : arr) {
                    if (value >= mid)
                        sum += mid;
                    else
                        sum += value;
                }
                if (sum > target)
                    end = mid - 1;
                else {
                    start = mid + 1;
                    answer = Math.max(answer, mid);
                }
            }
            System.out.println(answer);

        }

    }
}
