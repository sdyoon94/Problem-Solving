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
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = 1;
					++cheese;
				}
			}
		}
		int time = 0;
		ArrayList<int[]> melting = null;
		boolean[][] visit;
		Queue<int[]> q = new ArrayDeque<int[]>();
		int[] d = { 0, 1, 0, -1 };
		while (cheese > 0) {
			visit = new boolean[N][M];
			q.offer(new int[] { 0, 0 });
			melting = new ArrayList<>();
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				visit[cur[0]][cur[1]] = true;
				for (int i = 0; i < 4; i++) {
					int[] next = { cur[0] + d[i], cur[1] + d[3 - i] };
					if (next[0] < 0 || next[0] >= N || next[1] < 0 || next[1] >= M || visit[next[0]][next[1]])
						continue;
					visit[next[0]][next[1]] = true;
					if (map[next[0]][next[1]] == 1)
						melting.add(next);
					else
						q.offer(next);
				}
			}
			for (int[] i : melting) {
				map[i[0]][i[1]] = 0;
				--cheese;
			}
			++time;
		}
		System.out.print(time + "\n" + melting.size());
	}
}