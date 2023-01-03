import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] map;
    private static int[][] tmp;
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = 1 << Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        map = new int[N + 2][N + 2];
        tmp = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                tmp[i][j] = map[i][j];
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            rotate(1 << Integer.parseInt(st.nextToken()));
            melt();
        }
        int sum = 0, biggest = 0;
        boolean[][] visit = new boolean[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visit[i][j] || map[i][j] == 0) continue;
                int count = 1;
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i, j});
                visit[i][j] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    sum += map[cur[0]][cur[1]];
                    for (int k = 0; k < 4; k++) {
                        int[] next = new int[]{cur[0] + dr[k], cur[1] + dc[k]};
                        if (visit[next[0]][next[1]] || map[next[0]][next[1]] == 0) continue;
                        count++;
                        visit[next[0]][next[1]] = true;
                        q.add(next);
                    }
                }
                if (biggest < count) biggest = count;
            }
        }
        System.out.println(sum);
        System.out.println(biggest);
    }

    public static void rotate(int size) {
        if (size == 1) return;
        for (int i = 1; i <= N; i += size) {
            for (int j = 1; j <= N; j += size) {
                for (int k = 0; k < size; k++) {
                    for (int l = 0; l < size; l++) {
                        tmp[i + l][j + size - k - 1] = map[i + k][j + l];
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (N >= 0) System.arraycopy(tmp[i], 1, map[i], 1, N);
        }
    }

    public static void melt() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 0) continue;
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    if (map[i + dr[k]][j + dc[k]] == 0 && ++count > 1) {
                        tmp[i][j]--;
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (N >= 0) System.arraycopy(tmp[i], 1, map[i], 1, N);
        }
    }
}