import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long[][] route = { { 0, 1, 1, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0, 1, 1, 0 }, { 0, 0, 0, 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 1, 0 } };
	static long div = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int D = Integer.parseInt(br.readLine());
		System.out.print(solution(D)[0][0]);
	}

	public static long[][] solution(int n) {
		if (n == 1) {
			return route;
		}
		long[][] tmp = solution(n / 2);
		if (n % 2 == 1) {
			return mult(mult(tmp, tmp), route);
		} else {
			return mult(tmp, tmp);
		}
	}

	public static long[][] mult(long[][] a, long[][] b) {
		long[][] ans = new long[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					ans[i][j] += a[i][k] * b[k][j];
				}
				ans[i][j] %= div;
			}
		}
		return ans;
	}
}