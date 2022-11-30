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
		char[][] map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean[][][] visit = new boolean[N][M][2];
		Queue<ordi> q = new ArrayDeque<>();
		visit[0][0][0] = true;
		q.offer(new ordi(0, 0, false));
		int ans = 1;
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				ordi cur = q.poll();
				if (cur.r == N - 1 && cur.c == M - 1) {
					System.out.print(ans);
					return;
				}
				for (int j = 0; j < 4; j++) {
					int nextr = cur.r + dr[j];
					int nextc = cur.c + dc[j];
					if (nextr < 0 || nextr >= N || nextc < 0 || nextc >= M)
						continue;
					if (map[nextr][nextc] == '1') {
						if (!cur.crash) {
							q.offer(new ordi(nextr, nextc, true));
						}
					} else {
						if (cur.crash) {
							if (visit[nextr][nextc][0] | visit[nextr][nextc][1])
								continue;
							visit[nextr][nextc][1] = true;
							q.offer(new ordi(nextr, nextc, true));
						} else {
							if (visit[nextr][nextc][0])
								continue;
							visit[nextr][nextc][0] = true;
							q.offer(new ordi(nextr, nextc, false));
						}
					}
				}
			}
			ans++;
		}
		System.out.print(-1);
		return;
	}

	static class ordi {
		int r, c;
		boolean crash;

		public ordi(int r, int c, boolean crash) {
			super();
			this.r = r;
			this.c = c;
			this.crash = crash;
		}
	}
}