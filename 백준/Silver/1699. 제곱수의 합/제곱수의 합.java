import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		System.out.print(TD(N));
	}

	private static int TD(int n) {
		if (dp[n] != 0 || n == 0)
			return dp[n];
		dp[n] = n;
		for (int i = 2; i * i <= n; i++) {
			int tmp = TD(n % (i * i)) + n / (i * i);
			if (dp[n] > tmp)
				dp[n] = tmp;
		}
		return dp[n];
	}
}