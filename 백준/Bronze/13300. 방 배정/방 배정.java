import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] student = new int[2][6];
		while(N-- > 0) {
			String input = br.readLine();
			student[input.charAt(0) - '0'][input.charAt(2) - '0']++;
		}
		int ans = 0;
		for(int i = 0; i < 2; i++) for(int j = 0; j < 6; j++) ans += (student[i][j] + K - 1) / K;
		System.out.println(ans);
	}
}