import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int cnt = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = 1 << Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int col = Integer.parseInt(st.nextToken()) - 1;
        int row = Integer.parseInt(st.nextToken()) - 1;
        map = new int[K][K];
        dc(0, K, 0, K, row, col);
        map[row][col] = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 0; j < K; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dc(int startRow, int endRow, int startCol, int endCol, int row, int col) {
        if (endRow - startRow == 1) {
            return;
        }
        int midRow = (startRow + endRow) / 2;
        int midCol = (startCol + endCol) / 2;
        if (startRow <= row && row < midRow && startCol <= col && col < midCol) {
            map[midRow - 1][midCol] = map[midRow][midCol - 1] = map[midRow][midCol] = cnt++;
            dc(startRow, midRow, startCol, midCol, row, col);
            dc(startRow, midRow, midCol, endCol, midRow - 1, midCol);
            dc(midRow, endRow, startCol, midCol, midRow, midCol - 1);
            dc(midRow, endRow, midCol, endCol, midRow, midCol);
        } else if (startRow <= row && row < midRow && midCol <= col && col < endCol) {
            map[midRow - 1][midCol - 1] = map[midRow][midCol - 1] = map[midRow][midCol] = cnt++;
            dc(startRow, midRow, startCol, midCol, midRow - 1, midCol - 1);
            dc(startRow, midRow, midCol, endCol, row, col);
            dc(midRow, endRow, startCol, midCol, midRow, midCol - 1);
            dc(midRow, endRow, midCol, endCol, midRow, midCol);
        } else if (midRow <= row && row < endRow && startCol <= col && col < midCol) {
            map[midRow - 1][midCol - 1] = map[midRow - 1][midCol] = map[midRow][midCol] = cnt++;
            dc(startRow, midRow, startCol, midCol, midRow - 1, midCol - 1);
            dc(startRow, midRow, midCol, endCol, midRow - 1, midCol);
            dc(midRow, endRow, startCol, midCol, row, col);
            dc(midRow, endRow, midCol, endCol, midRow, midCol);
        } else {
            map[midRow - 1][midCol - 1] = map[midRow - 1][midCol] = map[midRow][midCol - 1] = cnt++;
            dc(startRow, midRow, startCol, midCol, midRow - 1, midCol - 1);
            dc(startRow, midRow, midCol, endCol, midRow - 1, midCol);
            dc(midRow, endRow, startCol, midCol, midRow, midCol - 1);
            dc(midRow, endRow, midCol, endCol, row, col);
        }
    }
}