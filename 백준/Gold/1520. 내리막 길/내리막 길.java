import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int dp[][], map[][], N, M, dr[] = { 0, -1, 0, 1 }, dc[] = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(dp[i], -1);
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		dp[M - 1][N - 1] = 1;
		System.out.print(dfs(0, 0));
	}

	static int dfs(int r, int c) {
		if (dp[r][c] != -1)
			return dp[r][c];

		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			try {
				if (map[nextR][nextC] < map[r][c])
					dp[r][c] += dfs(nextR, nextC);
			} catch (Exception e) {
				continue;
			}
		}
		return dp[r][c];
	}
}