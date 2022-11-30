import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int cheese = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j * 2) - '0';
				if (map[i][j] == 1)
					cheese++;
			}
		}

		Queue<Cheese> q = new ArrayDeque<>();
		int[][] visit;
		ArrayList<Cheese> meltingCheese;
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		int ans = 0;
		while (cheese > 0) {
			q.offer(new Cheese(0, 0));
			visit = new int[N][M];
			visit[0][0]++;
			meltingCheese = new ArrayList<>();
			while (!q.isEmpty()) {
				Cheese cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int r = cur.r + dr[i];
					int c = cur.c + dc[i];
					if (r < 0 || r >= N || c < 0 || c >= M)
						continue;
					if(map[r][c] == 0) {
						if(visit[r][c]++!=0) continue;
						q.offer(new Cheese(r, c));
					}
					else if(++visit[r][c] == 2) meltingCheese.add(new Cheese(r, c));
				}
			}
			for(Cheese i : meltingCheese) {
				map[i.r][i.c] = 0;
				cheese--;
			}
			ans++;
		}
		System.out.print(ans);
	}

	static class Cheese {
		int r, c;

		public Cheese(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}