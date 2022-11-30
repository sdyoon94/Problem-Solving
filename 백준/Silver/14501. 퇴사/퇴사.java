import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(subset(T, P, N, 0, 0));
	}

	private static int subset(int[] T, int[] P, int N, int sum, int index) {
		if(index == N) return sum;
		else if(index > N) return 0;
		return Math.max(subset(T, P, N, sum, index + 1), subset(T, P, N, sum + P[index], index + T[index]));
	}
}