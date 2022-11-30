import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(br.readLine());
			for (int j = cur; j <= k; j++) {
				dp[j] += dp[j - cur];
			}
		}
		System.out.println(dp[k]);
	}
}