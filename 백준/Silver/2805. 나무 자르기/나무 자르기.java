import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        int[] trees = new int[num];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            if(max<trees[i]) max = trees[i];
        }

        while(min<max){
            int mid = (min+max)/2;
            long sum = 0;

            for(int i=0; i<num; i++){
                if(trees[i]-mid>0){
                    sum+=(trees[i]-mid);
                }
            }

            if(sum<len){
                max = mid;
            }
            else{
                min = mid+1;
            }

        }

        System.out.println(min-1);


    }
}
