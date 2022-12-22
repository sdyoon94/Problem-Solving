import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int N, M, K, cur = 0;
    private static ArrayList<Fireball>[][][] map;
    private static final Queue<int[]> q = new ArrayDeque<>(), merge = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[2][N][N];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    map[i][j][k] = new ArrayList<Fireball>();
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            if (map[0][r][c].isEmpty()) {
                q.add(new int[]{r, c});
            }
            map[0][r][c].add(new Fireball(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < K; i++) {
            move();
            merge();
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int[] coor = q.poll();
            for (Fireball fireball : map[cur][coor[0]][coor[1]]) {
                ans += fireball.m;
            }
        }
        System.out.println(ans);
    }

    public static void move() {
        int size = q.size();
        int next = 1 - cur;
        for (int i = 0; i < size; i++) {
            int[] coor = q.poll();
            int row = coor[0];
            int col = coor[1];
            for (Fireball fireball : map[cur][row][col]) {
                int nextR = (row + dr[fireball.d] * fireball.s + 1000 * N) % N;
                int nextC = (col + dc[fireball.d] * fireball.s + 1000 * N) % N;
                if (map[next][nextR][nextC].isEmpty()) {
                    q.add(new int[]{nextR, nextC});
                } else if (map[next][nextR][nextC].size() == 1) {
                    merge.add(new int[]{nextR, nextC});
                }
                map[next][nextR][nextC].add(fireball);
            }
            map[cur][row][col].clear();
        }
        cur = next;
    }

    public static void merge() {
        while (!merge.isEmpty()) {
            int[] coor = merge.poll();
            int row = coor[0];
            int col = coor[1];
            int weight = 0;
            int oe = 0;
            int cnt = 0;
            int speed = 0;
            for (Fireball fireball : map[cur][row][col]) {
                cnt++;
                speed += fireball.s;
                oe += fireball.d & 1;
                weight += fireball.m;
            }
            if (oe == 0) oe = 1;
            else oe /= cnt;
            weight /= 5;
            speed /= cnt;
            map[cur][row][col].clear();
            if (weight != 0) {
                for (int i = 1 - oe; i < 8; i += 2) {
                    map[cur][row][col].add(new Fireball(weight, speed, i));
                }
            }
        }
    }

    public static class Fireball {
        int m, s, d;

        Fireball(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}