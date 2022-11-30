import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for(int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
		int ans = 0;
		for(int i = 0; i < R; i++) if(dfs(map, R, C, i, 0)) ans++;
		System.out.println(ans);
	}

	private static boolean dfs(char[][] map, int r, int c, int i, int j) {
		if(map[i][j] == 'x') return false;
		map[i][j] = 'x';
		if(j == c-1 || (i > 0 && dfs(map, r, c, i-1, j+1)) || dfs(map, r, c, i, j+1) || (i < r-1 && dfs(map, r, c, i+1, j+1))) return true;
		return false;
	}
}