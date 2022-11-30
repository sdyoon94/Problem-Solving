import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int un = 0;
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 2][M + 2];
		boolean[][] visit = new boolean[N + 1][M + 1];
		Queue<tomato> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				switch (Integer.parseInt(st.nextToken())) {
				case 1:
					q.offer(new tomato(i, j));
					visit[i][j] = true;
					map[i][j] = 1;
					break;
				case 0:
					map[i][j]=-1;
					un++;
					break;
				case -1:
					map[i][j]=0;
				}
			}
		}
		int ans = 0;
		while (!q.isEmpty() && un != 0) {
			int size = q.size();
			while (size-- > 0) {
				tomato cur = q.poll();
				for (int i = 0; i < 4; i++) {
					if (map[cur.r + dr[i]][cur.c + dc[i]] == -1) {
						map[cur.r + dr[i]][cur.c + dc[i]] = 1;
						visit[cur.r + dr[i]][cur.c + dc[i]] = true;
						q.offer(new tomato(cur.r + dr[i], cur.c + dc[i]));
						un--;
					}
				}
			}
			ans++;
		}
		if (un == 0)
			System.out.print(ans);
		else
			System.out.print(-1);
	}

	static class tomato {
		int r, c;

		public tomato(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}