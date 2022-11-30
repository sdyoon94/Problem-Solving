import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++)
				map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		while(M-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1, y1, x2, y2;
			x1 = Integer.parseInt(st.nextToken()) - 1;
			y1 = Integer.parseInt(st.nextToken()) - 1;
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			sb.append(map[x2][y2] - map[x1][y2] - map[x2][y1] + map[x1][y1]).append("\n");
		}
		System.out.print(sb.toString());
	}
}