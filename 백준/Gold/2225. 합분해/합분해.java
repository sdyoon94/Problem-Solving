import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 200
		int K = Integer.parseInt(st.nextToken()); // 1 <= K <= 200
		int[] D = new int[N + 1];
		D[0] = 1;
		for (int i = 0; i < K; i++) {
			for (int j = 1; j <= N; j++) {
				D[j] += D[j - 1];
				if (D[j] > 1000000000)
					D[j] -= 1000000000;
			}
		}
		System.out.print(D[N]);
	}
}