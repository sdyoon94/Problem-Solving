import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		int[][] visit = new int[H][W];
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < H; i++) {
			String input = br.readLine();
			for (int j = 0; j < W; j++) {
				visit[i][j] = max;
				if (input.charAt(j * 2) == '1')
					map[i][j] = 1;
			}
		}
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { 0, 0, 0 });
		visit[0][0] = 0;
		int[] d = { 0, -1, 0, 1 };
		int[] e = { -1, -1, 1, 1, -2, 2, -2, 2 };
		int ans = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				if (cur[0] == H - 1 && cur[1] == W - 1) {
					System.out.print(ans);
					return;
				}
				for (int i = 0; i < 4; i++) {
					int[] next = { cur[0] + d[i], cur[1] + d[3 - i], cur[2] };
					if (next[0] < 0 || next[0] >= H || next[1] < 0 || next[1] >= W || map[next[0]][next[1]] == 1 || visit[next[0]][next[1]] <= next[2])
						continue;
					visit[next[0]][next[1]] = next[2];
					q.offer(next);
				}
				if (cur[2] == K)
					continue;
				for (int i = 0; i < 8; i++) {
					int[] next = { cur[0] + e[i], cur[1] + e[7 - i], cur[2] + 1 };
					if (next[0] < 0 || next[0] >= H || next[1] < 0 || next[1] >= W || map[next[0]][next[1]] == 1 || visit[next[0]][next[1]] <= next[2])
						continue;
					visit[next[0]][next[1]] = next[2];
					q.offer(next);
				}
			}
			ans++;
		}
		System.out.print(-1);
	}
}