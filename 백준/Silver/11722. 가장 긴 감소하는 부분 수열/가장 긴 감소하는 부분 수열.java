import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] dp = new int[N + 1];
		dp[1] = Integer.parseInt(st.nextToken());
		int size = 1;
		for (int i = 1; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (cur < dp[size]) {
				dp[++size] = cur;
			} else {
				dp[find(dp, 1, size, cur)] = cur;
			}
		}
		System.out.print(size);
	}

	private static int find(int[] dp, int start, int end, int goal) {
		if (start == end)
			return start;
		int mid = (start + end) / 2;
		if(dp[mid] == goal) return mid;
		if(dp[mid] > goal) return find(dp, mid + 1, end, goal);
		return find(dp, start, mid, goal);
	}
}