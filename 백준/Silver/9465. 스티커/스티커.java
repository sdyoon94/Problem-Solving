import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] input = new int[2][N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++)
				input[0][j] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++)
				input[1][j] = Integer.parseInt(st.nextToken());
			
			for (int i = 2; i <= N; i++) {
				input[0][i] += Math.max(input[1][i-1], input[1][i-2]);
				input[1][i] += Math.max(input[0][i-1], input[0][i-2]);
			}
			sb.append(Math.max(input[0][N], input[1][N])).append("\n");
		}
		System.out.print(sb);
	}
}