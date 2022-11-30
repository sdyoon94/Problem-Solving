import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		final int n = 10007;
		int[] dp = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		for (int i = 1; i < N; i++)
			for (int j = 1; j < 10; j++)
				dp[j] = (dp[j - 1] + dp[j]) % n;
		int ans = 1;
		for (int i = 1; i < 10; i++)
			ans += dp[i];
		System.out.print(ans % n);
	}
}