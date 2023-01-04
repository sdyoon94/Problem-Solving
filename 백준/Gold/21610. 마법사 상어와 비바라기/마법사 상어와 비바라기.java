import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    private static boolean[][] visit;
    private static int N;
    private static int M;
    private static int[][] map;
    private static final ArrayList<int[]> al = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        al.add(new int[]{N - 1, 0});
        al.add(new int[]{N - 1, 1});
        al.add(new int[]{N - 2, 0});
        al.add(new int[]{N - 2, 1});
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            rain(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += map[i][j];
            }
        }
        System.out.println(ans);
    }

    public static void rain(int d, int s) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[i], false);
        }
        for (int[] cur : al) {
            cur[0] = (N + cur[0] + dr[d] * (s % N)) % N;
            cur[1] = (N + cur[1] + dc[d] * (s % N)) % N;
            map[cur[0]][cur[1]]++;
            visit[cur[0]][cur[1]] = true;
        }
        for (int[] cur : al) {
            for (int j = 2; j < 9; j += 2) {
                int nnR = cur[0] + dr[j];
                int nnC = cur[1] + dc[j];
                if (0 <= nnR && nnR < N && 0 <= nnC && nnC < N && map[nnR][nnC] > 0) {
                    map[cur[0]][cur[1]]++;
                }
            }
        }
        al.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1 && !visit[i][j]) {
                    al.add(new int[]{i, j});
                    map[i][j] -= 2;
                }
            }
        }
    }
}