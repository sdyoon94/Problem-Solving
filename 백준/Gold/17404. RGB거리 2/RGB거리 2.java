import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 2 <= N <= 1000
		int[][] P = new int[N][3]; // P <= 1000, 자연수

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				P[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] D = new int[3][N][3];
		int INF = 1000 * 1000 + 17;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 3; k++) {
					D[i][j][k] = INF;
				}
			}
		}
		D[0][0][0] = P[0][0];
		D[1][0][1] = P[0][1];
		D[2][0][2] = P[0][2];
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < N; j++) {
				for (int k = 0; k < 3; k++) {
					D[i][j][k] = Math.min(D[i][j - 1][(k + 1) % 3], D[i][j - 1][(k + 2) % 3]) + P[j][k];
				}
			}
		}
		int ans = INF;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (D[i][N - 1][j] < ans && i != j) {
					ans = D[i][N - 1][j];
				}
			}
		}
		System.out.print(ans);
	}
}