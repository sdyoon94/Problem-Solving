import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dp[], cur;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		dp = new int[N];
		dp[0] = Integer.parseInt(st.nextToken());
		int size = 0;
		for (int i = 1; i < N; i++) {
			cur = Integer.parseInt(st.nextToken());
			if (cur > dp[size]) {
				dp[++size] = cur;
			} else {
				dp[find(0, size)] = cur;
			}
		}
		System.out.print(size + 1);
	}

	private static int find(int start, int end) {
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if(dp[mid]==cur) return mid;
			if(dp[mid]<cur) start = mid+1;
			else end = mid - 1;
		}
		return start;
	}
}