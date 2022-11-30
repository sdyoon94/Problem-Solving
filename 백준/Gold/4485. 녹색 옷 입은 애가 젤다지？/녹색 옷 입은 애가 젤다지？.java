import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, T = 0;
		StringBuilder sb = new StringBuilder();
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			sb.append("Problem ").append(++T).append(": ");
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++)
					map[i][j] = input.charAt(j * 2) - '0';
			}

			PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
			int[][] d = new int[N][N];
			for (int i = 0; i < N; i++)
				Arrays.fill(d[i], Integer.MAX_VALUE);
			int[] dir = { -1, 0, 1, 0 };
			q.offer(new int[] { 0, 0, map[0][0] });
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				if (d[cur[0]][cur[1]] != Integer.MAX_VALUE)
					continue;
				d[cur[0]][cur[1]] = cur[2];
				if (cur[0] == N - 1 && cur[1] == N - 1)
					break;
				for (int i = 0; i < 4; i++) {
					int[] next = { cur[0] + dir[i], cur[1] + dir[3 - i], cur[2] };
					if (next[0] < 0 || next[0] == N || next[1] < 0 || next[1] == N || d[next[0]][next[1]] != Integer.MAX_VALUE)
						continue;
					next[2] += map[next[0]][next[1]];
					q.offer(next);
				}
			}
			sb.append(d[N - 1][N - 1]).append("\n");
		}
		System.out.print(sb.toString());
	}
}