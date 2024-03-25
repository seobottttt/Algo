import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] moveRow = {1, -1, 0, 0};
    static int[] moveCol = {0, 0, 1, -1};
    static int[][] square;
    static int row = 0;
    static int col = 0;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        square = new int[row][col];
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int startCol = Integer.parseInt(st.nextToken());
            int startRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());

            for (int j = startRow; j <= endRow - 1; j++) {
                for (int k = startCol; k <= endCol - 1; k++) {
                    square[j][k] = 1;
                }
            }
        }

        int answer = 0;
        List<Integer> sizeList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (square[i][j] != 1) {
                    answer++;
                    DFS(i, j);
                    sizeList.add(size);
                    size = 0;
                }
            }
        }

        Collections.sort(sizeList);

        System.out.println(answer);
        for (Integer si : sizeList) {
            System.out.print(si+" ");
        }


    }

    public static void DFS(int r, int c) {
        size++;
        square[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nextRow = r + moveRow[i];
            int nextCol = c + moveCol[i];

            if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col) {
                if (square[nextRow][nextCol] == 0) {
                    DFS(nextRow, nextCol);
                }
            }
        }

    }
}
