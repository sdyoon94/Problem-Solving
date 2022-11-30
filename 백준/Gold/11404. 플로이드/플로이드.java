import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] adj = new int[N + 1][N + 1];
		int max = 123456789;
		for (int i = 1; i <= N; i++)
			Arrays.fill(adj[i], max);
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (adj[from][to] > cost)
				adj[from][to] = cost;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (k == i || k == j)
						continue;
					if (adj[j][k] > adj[j][i] + adj[i][k])
						adj[j][k] = adj[j][i] + adj[i][k];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				sb.append(adj[i][j] == max ? 0 : adj[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}