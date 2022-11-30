import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int ans = 0, N, M, max;
    private static int[][] map, copyMap;
    private static int[] dc = {0, -1, 0, 1}, dr = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = N * M;
        map = new int[N + 2][M + 2];
        copyMap = new int[N + 2][M + 2];
        for (int i = 0; i < N + 2; i++) {
            map[i][0] = 1;
            map[i][M + 1] = 1;
        }
        for (int i = 1; i <= M; i++) {
            map[0][i] = 1;
            map[N + 1][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        permu(0, 0);

        System.out.println(ans);
    }

    public static void permu(int cnt, int idx) {
        if (cnt == 3) {
            for (int i = 0; i < N + 2; i++) {
                if (M + 2 >= 0) System.arraycopy(map[i], 0, copyMap[i], 0, M + 2);
            }
            Queue<int[]> q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (copyMap[i][j] == 2) {
                        q.offer(new int[]{i, j});
                    }
                }
            }
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int[] next = {cur[0] + dr[i], cur[1] + dc[i]};
                    if (copyMap[next[0]][next[1]] == 0) {
                        copyMap[next[0]][next[1]] = 2;
                        q.offer(next);
                    }
                }
            }
            int ansCnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (copyMap[i][j] == 0) {
                        ansCnt++;
                    }
                }
            }
            if (ans < ansCnt) {
                ans = ansCnt;
            }
        } else {
            for (int i = idx; i < max; i++) {
                int row = i / M + 1;
                int col = i % M + 1;
                if (map[row][col] == 0) {
                    map[row][col] = 1;
                    permu(cnt + 1, i + 1);
                    map[row][col] = 0;
                }
            }
        }
    }
}