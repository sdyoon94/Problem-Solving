import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] matrix;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][N];
        System.out.println(dp(0, N - 1));
    }

    public static int dp(int start, int end) {
        if (start == end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int cur = dp(start, i) + dp(i + 1, end) + matrix[start][0] * matrix[i][1] * matrix[end][1];
            if (ans > cur) ans = cur;
        }
        return dp[start][end] = ans;
    }
}