import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int cur = Integer.parseInt(st.nextToken());
                points[i][j] = cur;
            }
        }

        int[][] maxDp = new int[n][3];
        maxDp[0][0] = points[0][0];
        maxDp[0][1] = points[0][1];
        maxDp[0][2] = points[0][2];

        int[][] minDp = new int[n][3];
        minDp[0][0] = points[0][0];
        minDp[0][1] = points[0][1];
        minDp[0][2] = points[0][2];


        int max = 0;
        int min = 1000000;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxDp[i][j] = Math.max(points[i][j] + maxDp[i - 1][0], points[i][j] + maxDp[i - 1][1]);
                    minDp[i][j] = Math.min(points[i][j] + minDp[i - 1][0], points[i][j] + minDp[i - 1][1]);
                } else if (j == 1) {
                    maxDp[i][j] = Math.max(points[i][j] + maxDp[i - 1][0], points[i][j] + maxDp[i - 1][1]);
                    maxDp[i][j] = Math.max(maxDp[i][j], points[i][j] + maxDp[i - 1][2]);

                    minDp[i][j] = Math.min(points[i][j] + minDp[i - 1][0], points[i][j] + minDp[i - 1][1]);
                    minDp[i][j] = Math.min(minDp[i][j], points[i][j] + minDp[i - 1][2]);

                } else {
                    maxDp[i][j] = Math.max(points[i][j] + maxDp[i - 1][1], points[i][j] + maxDp[i - 1][2]);
                    minDp[i][j] = Math.min(points[i][j] + minDp[i - 1][1], points[i][j] + minDp[i - 1][2]);
                }
            }
        }

        for(int i=0; i<3; i++){
            max = Math.max(max,maxDp[n-1][i]);
            min = Math.min(min,minDp[n-1][i]);
        }

        System.out.println(max + " " +min);

    }
}
