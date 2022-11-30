import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] belt = new int[N];
		for (int i = 0; i < N; i++)
			belt[i] = Integer.parseInt(br.readLine());

		int[] sushi = new int[d + 1];
		int ans = 0, cur = 1;
		++sushi[c];
		for (int i = 0; i < k; i++) {
			if (sushi[belt[i]]++ == 0)
				cur++;
		}

		for (int i = 0, j = k; i < N; i++, j = j == N - 1 ? 0 : j + 1) {
			if (ans < cur)
				ans = cur;
			if (--sushi[belt[i]] == 0)
				cur--;
			if (sushi[belt[j]]++ == 0)
				cur++;
		}
		System.out.print(ans);
	}
}