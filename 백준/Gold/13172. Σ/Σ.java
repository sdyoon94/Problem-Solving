import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long mod = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		long ans = 0;
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long N = Long.parseLong(st.nextToken());
			long S = Long.parseLong(st.nextToken());
			long gcd = gcd(N, S);
			N /= gcd;
			S /= gcd;
			ans = (ans + S * pow(N, mod - 2)) % mod;
		}
		System.out.print(ans);
	}

	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	static long pow(long a, long b) {
		if (b == 1)
			return a;
		if (b % 2 == 0)
			return pow((a * a) % mod, b / 2);
		return (pow(a, b - 1) * a) % mod;
	}
}