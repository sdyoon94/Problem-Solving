import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    private static int[][] map;
    private static boolean[][] cleared;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cleared = new boolean[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int curR = Integer.parseInt(st.nextToken());
        int curC = Integer.parseInt(st.nextToken());
        int curD = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    map[i][j] = 1;
                }
            }
        }

        int ans = 0;

        boolean isEnd = false;
        while (true) {
            if (!cleared[curR][curC]) {
                cleared[curR][curC] = true;
                ans++;
            }
            while (true) {
                int leftD = (curD + 3) % 4;
                int leftR = curR + dr[leftD];
                int leftC = curC + dc[leftD];
                if (map[leftR][leftC] == 0 && !cleared[leftR][leftC]) {
                    curR = leftR;
                    curD = leftD;
                    curC = leftC;
                    break;
                } else {
                    boolean four = true;
                    for (int i = 0; i < 4; i++) {
                        int nextR = curR + dr[i];
                        int nextC = curC + dc[i];
                        if (map[nextR][nextC] == 0 && !cleared[nextR][nextC]) {
                            four = false;
                            break;
                        }
                    }
                    if (!four) {
                        curD = leftD;
                        continue;
                    } else {
                        int backR = curR - dr[curD];
                        int backC = curC - dc[curD];
                        if (map[backR][backC] == 0) {
                            curR = backR;
                            curC = backC;
                            continue;
                        } else {
                            isEnd = true;
                            break;
                        }
                    }
                }
            }
            if (isEnd) {
                break;
            }
        }

        System.out.println(ans);
    }
}