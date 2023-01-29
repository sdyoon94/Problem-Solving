import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n, m, target1, target2, x, y;
    private static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine()); // n := 정점의 수, 1 <= n <= 100
        st = new StringTokenizer(br.readLine(), " ");
        target1 = Integer.parseInt(st.nextToken()); // target1 := 촌수를 계산해야 하는 사람
        target2 = Integer.parseInt(st.nextToken()); // target2 := 촌수를 계산해야 하는 사람
        m = Integer.parseInt(br.readLine()); // m := 간선의 수, m < n
        // 인접 리스트 초기화 시작
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        // 인접 리스트 초기화 끝
        // 가족관계 입력 시작
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
        // 가족관계 입력 끝
        System.out.println(bfs()); // 답 출력
    }

    /**
     * target1으로부터 target2까지의 촌수를 구하는 Method
     *
     * @return target1, target2 사이의 촌수, 친척이 아닐 경우 -1
     */
    public static int bfs() {
        int ans = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        // 촌수를 계산해야하는 사람을 root로 탐색 시작
        q.add(target1);
        visited[target1] = true;
        while (!q.isEmpty()) {
            ans++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int next : adj[cur]) {
                    if (next == target2) return ans;
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }
        return -1;
    }
}