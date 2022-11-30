import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int[][][] root;
	static char[][] map;
	static boolean[][] visit;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ans = N*M;
		map = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		root = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				root[i][j][0] = i;
				root[i][j][1] = j;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {
					dfs(i, j);
				}
			}
		}
		System.out.println(ans);
	}

	public static void dfs(int r, int c) {
		visit[r][c] = true;
		int nextR = r, nextC = c;
		switch (map[r][c]) {
		case 'D':
			nextR++;
			break;
		case 'R':
			nextC++;
			break;
		case 'U':
			nextR--;
			break;
		case 'L':
			nextC--;
			break;
		}
		if (!union(root[r][c], root[nextR][nextC]))
			dfs(nextR, nextC);
	}

	public static boolean union(int[] a, int[] b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return true;
		root[b[0]][b[1]] = a;
		ans--;
		return false;
	}

	public static int[] find(int[] a) {
		if (root[a[0]][a[1]] == a)
			return a;
		return root[a[0]][a[1]] = find(root[a[0]][a[1]]);
	}
}