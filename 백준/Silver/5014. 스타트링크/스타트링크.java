import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		if ((S < G && U == 0) || (S > G && D == 0)) {
			System.out.print("use the stairs");
			return;
		}
		boolean[] visit = new boolean[F + 1];
		int ans = 0;
		while (S != G) {
			if (visit[S]) {
				System.out.print("use the stairs");
				return;
			}
			visit[S] = true;
			ans++;
			if (S < G && S + U <= F)
				S += U;
			else if (S > G && S - D > 0)
				S -= D;
			else if (S < G && S - D > 0)
				S -= D;
			else if (S > G && S + U <= F)
				S += U;
			else {
				System.out.print("use the stairs");
				return;
			}
		}
		System.out.print(ans);
	}
}