import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int r;
    private static int c;
    private static int size = 2;
    private static int ans = 0;
    private static int ate = 0;
    private static int canEat = 0;
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int[] fish;
    private static Queue<int[]> q = new ArrayDeque<>();
    private static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[0] == b[0]) {
            return a[1] - b[1];
        } else {
            return a[0] - b[0];
        }
    });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        fish = new int[7];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (1 <= cur && cur <= 6) {
                    fish[cur]++;
                    map[i][j] = cur;
                } else if (cur == 9) {
                    r = i;
                    c = j;
                }
            }
        }

        canEat = fish[1];
        boolean chk;
        while (canEat > 0) {
            chk = false;
            q.add(new int[]{r, c});
            visited[r][c] = true;
            int time = 0;
            while (!q.isEmpty()) {
                time++;
                int qSize = q.size();
                while (qSize-- > 0) {
                    int[] cur = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int[] nextCor = {cur[0] + dr[i], cur[1] + dc[i]};
                        if (nextCor[0] < 0 || nextCor[0] == N || nextCor[1] < 0 || nextCor[1] == N || visited[nextCor[0]][nextCor[1]]) {
                            continue;
                        }
                        int there = map[nextCor[0]][nextCor[1]];
                        if (there != 0 && there < size) {
                            pq.add(nextCor);
                        } else if (there == 0 || there == size) {
                            q.add(nextCor);
                            visited[nextCor[0]][nextCor[1]] = true;
                        }
                    }
                }
                if (!pq.isEmpty()) {
                    eat(pq.poll());
                    ans += time;
                    chk = true;
                    break;
                }
            }
            if(!chk){
                break;
            }
        }
        System.out.println(ans);
    }

    public static void eat(int[] cor) {
        ate++;
        canEat--;
        map[cor[0]][cor[1]] = 0;
        r = cor[0];
        c = cor[1];
        if (ate == size) {
            grow();
        }
        pq.clear();
        q.clear();
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public static void grow() {
        if(size==7) return;
        canEat += fish[size];
        size++;
        ate = 0;
    }
}