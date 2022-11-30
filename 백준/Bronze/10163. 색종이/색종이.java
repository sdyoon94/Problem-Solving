import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] paper = new int[1001][1001];
		int N = Integer.parseInt(br.readLine());
		int[] ans = new int[N+1];
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for(int j = x; j < x+w; j++) {
				for(int k = y; k < y+h; k++) {
					ans[paper[j][k]]--;
					ans[i]++;
					paper[j][k]=i;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) sb.append(ans[i]).append("\n");
		System.out.println(sb.toString());
	}
}