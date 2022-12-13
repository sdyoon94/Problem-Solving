import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<ArrayList<Integer>> adj;
    private static int[][] dp;
    private static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dp = new int[N + 1][2];
        visit = new boolean[N + 1];
        dfs(1);
        System.out.println(Integer.min(dp[1][0], dp[1][1]));
    }

    public static void dfs(int n) {
        dp[n][0] = 0;
        dp[n][1] = 1;
        visit[n] = true;
        for (int child : adj.get(n)) {
            if (visit[child]) continue;
            dfs(child);
            dp[n][0] += dp[child][1];
            dp[n][1] += Integer.min(dp[child][0], dp[child][1]);
        }
    }
}