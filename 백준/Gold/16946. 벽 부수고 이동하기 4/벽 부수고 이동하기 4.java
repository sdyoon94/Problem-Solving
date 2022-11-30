import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static boolean[][] visited;
	private static int[][] groupNum, ans;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		groupNum = new int[N][M];
		ArrayList<Integer> al = new ArrayList<>();
		al.add(0);
		int cnt = 1;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				if (input.charAt(j) == '1') {
					visited[i][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					al.add(dfs(i, j, cnt++));
				}
			}
		}

		HashSet<Integer> hs = new HashSet<>();
		ans = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (groupNum[i][j] == 0) {
					ans[i][j] = 1;
					for (int k = 0; k < 4; k++) {
						int r = i + dr[k];
						int c = j + dc[k];
						if (r < 0 || r == N || c < 0 || c == M)
							continue;
						hs.add(groupNum[r][c]);
					}
					for (int gn : hs) {
						ans[i][j] += al.get(gn);
					}
					hs.clear();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(ans[i][j] % 10);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	public static int dfs(int r, int c, int n) {
		groupNum[r][c] = n;
		visited[r][c] = true;
		int ans = 1;
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR < 0 || nextR == N || nextC < 0 || nextC == M || visited[nextR][nextC])
				continue;
			ans += dfs(nextR, nextC, n);
		}
		return ans;
	}
}