import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(br.readLine());
			for (int j = cur; j <= k; j++) {
				if (dp[j - cur] == -1)
					continue;
				if (dp[j] == -1 || dp[j] > dp[j - cur] + 1)
					dp[j] = dp[j - cur] + 1;
			}
		}
		System.out.println(dp[k]);
	}
}