import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 한 칸 마다 bfs 다 돌려서 끝나는 지점 카운트 세아리고
    // max 값이랑 비교함
    static int[][] cntMap;
    static Queue<Pair> q = new LinkedList<>();
    static int[] moveRow = {1, -1, 0, 0};
    static int[] moveCol = {0, 0, 1, -1};
    static int row;
    static int col;

    public static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];

        for (int i = 0; i < row; i++) {
            String cur = br.readLine();
            for (int j = 0; j < col; j++) {
                if (cur.charAt(j) == 'W') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    // BFS
                    cntMap = new int[row][col];
                    copyMap(map);
                    int comp = BFS(i, j);
                    answer = Math.max(answer, comp);
                }
            }
        }

        System.out.println(answer);

    }

    private static void copyMap(int[][] map) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cntMap[i][j] = map[i][j];
            }
        }
    }

    public static int BFS(int r, int c) {
        int ans = 0;
        Pair p = new Pair(r, c);
        q.add(p);
        cntMap[r][c] = 1;

        while (!q.isEmpty()) {
            int curRow = q.peek().first;
            int curCol = q.peek().second;
            ans = Math.max(ans, cntMap[curRow][curCol] - 1);
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + moveRow[i];
                int nextCol = curCol + moveCol[i];


                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col) {
                    if (cntMap[nextRow][nextCol] == 0) {
                        cntMap[nextRow][nextCol] = cntMap[curRow][curCol] + 1;
                        p = new Pair(nextRow, nextCol);
                        q.add(p);
                    }
                }

            }
        }

        return ans;

    }
}
