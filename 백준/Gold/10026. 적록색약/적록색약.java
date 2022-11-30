import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] normal = new char[N][N];
		char[][] rg = new char[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < N; j++) {
				normal[i][j] = input.charAt(j);
				if(input.charAt(j)=='G') rg[i][j] = 'R';
				else rg[i][j] = normal[i][j];
			}
		}
		System.out.print(bfs(normal) + " " + bfs(rg));
	}

	public static int bfs(char[][] map) {
		int N = map.length;
		Queue<Integer[]> q = new ArrayDeque<Integer[]>();
		boolean[][] visit = new boolean[N][N];
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j])
					continue;
				char color = map[i][j];
				ans++;
				q.add(new Integer[] { i, j });
				visit[i][j] = true;
				while (!q.isEmpty()) {
					Integer[] tmp = q.poll();
					for (int k = 0; k < 4; k++) {
						int x = tmp[0] + dx[k];
						int y = tmp[1] + dy[k];
						try {
							if (!visit[x][y] && map[x][y] == color) {
								visit[x][y] = true;
								q.add(new Integer[] { x, y });
							}
						} catch (ArrayIndexOutOfBoundsException e) {
						}
					}
				}
			}
		}
		return ans;
	}
}