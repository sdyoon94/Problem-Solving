import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1000000003;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][K + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }
        dp[1][1] = 1;
        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        System.out.println((dp[N - 3][K - 1] + dp[N - 1][K]) % MOD);
    }
}