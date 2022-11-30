import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] know = new boolean[N + 1];
		boolean[][] adj = new boolean[N + 1][N + 1];
		Queue<Integer> q = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine(), " ");
		int tmp = Integer.parseInt(st.nextToken());
		for (int i = 0; i < tmp; i++) {
			int input = Integer.parseInt(st.nextToken());
			know[input] = true;
			q.add(input);
		}
		int[][] party = new int[M][];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			tmp = Integer.parseInt(st.nextToken());
			party[i] = new int[tmp];
			for (int j = 0; j < tmp; j++)
				party[i][j] = Integer.parseInt(st.nextToken());
			for (int j : party[i]) {
				for (int k : party[i]) {
					if (j == k)
						continue;
					adj[j][k] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (adj[cur][i] && !know[i]) {
					know[i] = true;
					q.offer(i);
				}
			}
		}
		int ans = 0;
		for (int[] i : party) {
			boolean chk = true;
			for (int j : i) {
				if (know[j]) {
					chk = false;
					break;
				}
			}
			if (chk)
				ans++;
		}
		System.out.print(ans);
	}
}