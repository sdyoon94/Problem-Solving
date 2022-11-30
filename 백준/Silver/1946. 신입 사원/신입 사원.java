import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int[] rank = new int[N+1];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				rank[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			int ans = 1, cutline = rank[1];
			for(int i = 2; i <= N; i++) {
				if(rank[i] > cutline) continue;
				cutline = rank[i];
				ans++;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}