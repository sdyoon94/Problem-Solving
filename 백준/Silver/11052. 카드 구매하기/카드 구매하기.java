import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), tmp, i, j, k;
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (i = 1; i <= N; ++i)
			dp[i] = Integer.parseInt(st.nextToken());
		for (i = 2; i <= N; ++i) {
			k = i >> 1;
			for(j = 1; j <= k; j++) {
				tmp = dp[j] + dp[i - j];
				if (tmp > dp[i])
					dp[i] = tmp;
			}
		}
		System.out.print(dp[N]);
	}
}