import java.io.*;
import java.util.*;

// 벽 3개를 세워야함
// 0인 지점에 랜덤으로 벽 3개를 세우는 모든 경우에 안전영역을 다 탐색해야함
// 벽 3개를 어떻게 세울까 ?

public class Main {

    static int row;
    static int col;
    static int[][] graph = new int[8][8];
    static boolean[][] visited = new boolean[8][8];
    static Queue<int[]> q = new ArrayDeque<>();
    static int[][] copy = new int[8][8];
    static int[] move_row = {1, -1, 0, 0};
    static int[] move_col = {0, 0, 1, -1};
    static int answer = 0;
    static int result = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bruteForce(0);

        System.out.println(answer);

    }


    private static void bruteForce(int num) {
        if (num == 3) {

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    copy[i][j] = graph[i][j];
                    if (copy[i][j] == 2) q.add(new int[]{i, j});
                    // 바이러스 q에 넣기
                }
            }

            bfs();


            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (copy[i][j] == 0) {
                        result++;
                    }
                }
            }

            answer = Math.max(answer, result);

            // 방문 배열 초기화
            visited = new boolean[row][col];
            result = 0;


            return;
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    bruteForce(num + 1);
                    graph[i][j] = 0;
                }
            }
        }

    }

    private static void bfs() {


        while (!q.isEmpty()) {

            int curRow = q.peek()[0];
            int curCol = q.peek()[1];

            q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + move_row[i];
                int nextCol = curCol + move_col[i];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < row && nextCol < col) {
                    if (!visited[nextRow][nextCol] && copy[nextRow][nextCol] == 0) {
                        visited[nextRow][nextCol] = true;
                        q.add(new int[]{nextRow, nextCol});
                        copy[nextRow][nextCol] = 2; // 바이러스 번짐
                    }
                }

            }

        }

    }


}
