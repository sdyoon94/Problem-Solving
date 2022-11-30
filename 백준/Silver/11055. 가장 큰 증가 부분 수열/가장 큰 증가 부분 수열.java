import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		int[] A = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			dp[i] = A[i];
			for (int j = 0; j < i; j++)
				if (A[i] > A[j])
					dp[i] = Math.max(dp[j] + A[i], dp[i]);
		}
		
		int ans = 0;
		for (int i = 1; i <= n; ++i)
			if (ans < dp[i])
				ans = dp[i];
		System.out.println(ans);
	}
}