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
		for (int i = 0; i < N; ++i)
			map[i] = br.readLine().toCharArray();
		System.out.print(bfs(map, N, M));
	}

	static int bfs(char[][] map, int N, int M) {
		int[] start = new int[3];
		A: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					start[0] = i;
					start[1] = j;
					map[i][j] = '.';
					break A;
				}
			}
		}
		boolean[][][] visit = new boolean[N][M][128];
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, -1, 0, 1 };
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(start);
		int time = 0;
		while (!q.isEmpty()) {
			time++;
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int[] next = { cur[0] + dr[i], cur[1] + dc[i], cur[2] };
					if (next[0] < 0 || next[0] == N || next[1] < 0 || next[1] == M || visit[next[0]][next[1]][next[2]])
						continue;
					visit[next[0]][next[1]][next[2]] = true;
					char block = map[next[0]][next[1]];
					boolean chk = true;
					switch (block) {
					case '1':
						return time;
					case 'a':
					case 'b':
					case 'c':
					case 'd':
					case 'e':
					case 'f':
						next[2] |= 1 << block - 'a';
						break;
					case '.':
						break;
					case '#':
						chk = false;
						break;
					default:
						if ((next[2] & 1 << block - 'A') == 0)
							chk = false;
					}
					if (chk)
						q.offer(next);
				}
			}
		}

		return -1;
	}
}