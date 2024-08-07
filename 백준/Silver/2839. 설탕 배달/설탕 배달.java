import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int weight = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while(weight>=0){
            if(weight%5==0){
                cnt += (weight/5);
                System.out.println(cnt);
                return;
            }
            else{
                weight -= 3;
                cnt++;
            }
        }

        System.out.println(-1);
    }
}
