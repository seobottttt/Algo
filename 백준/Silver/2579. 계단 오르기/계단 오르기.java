import java.io.*;
import java.util.*;

public class Main {

    //개수 하한선 없음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] DP = new int[301];
        int[] point = new int[301];

        for(int i=1; i<=n; i++){
            point[i] = Integer.parseInt(br.readLine());
        }

        DP[1] = point[1];
        DP[2] = DP[1]+point[2];
        DP[3] = Math.max(point[2]+point[3],DP[1]+point[3]);

        for(int i=4; i<=n; i++){
            DP[i] = Math.max(point[i-1]+DP[i-3]+point[i],DP[i-2]+point[i]);
        }

        System.out.println(DP[n]);


    }

}
