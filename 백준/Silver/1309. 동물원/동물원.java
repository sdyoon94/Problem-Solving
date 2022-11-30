import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N + 1];
		D[0] = 0;
		D[1] = 2;
		int S = 1;
		for (int i = 2; i <= N; i++) {
			D[i] = D[i - 1] + 2 * S;
			S += D[i - 1];
			if (D[i] > 9901) {
				D[i] %= 9901;
				S %= 9901;
			}
		}
		System.out.print((D[N] + S) % 9901);
	}
}
