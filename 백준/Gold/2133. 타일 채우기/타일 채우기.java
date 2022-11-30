import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if ((N & 1) == 1)
			System.out.print(0);
		else {
			N >>= 1;
			int[] dp = new int[N + 1];
			dp[0] = 1;
			dp[1] = 3;
			int sum = 1;
			for (int i = 2; i <= N; i++) {
				dp[i] = dp[i - 1] * 3 + sum * 2;
				sum += dp[i - 1];
			}
			System.out.print(dp[N]);
		}
	}
}