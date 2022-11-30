import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] max = new int[3][N+1];
		int[][] min = new int[3][N+1];
		int input;
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			input = Integer.parseInt(st.nextToken());
			max[0][i] = Math.max(max[0][i-1], max[1][i-1]) + input;
			min[0][i] = Math.min(min[0][i-1], min[1][i-1]) + input;
			input = Integer.parseInt(st.nextToken());
			max[1][i] = Math.max(max[0][i-1], Math.max(max[1][i-1], max[2][i-1])) + input;
			min[1][i] = Math.min(min[0][i-1], Math.min(min[1][i-1], min[2][i-1])) + input;
			input = Integer.parseInt(st.nextToken());
			max[2][i] = Math.max(max[2][i-1], max[1][i-1]) + input;
			min[2][i] = Math.min(min[2][i-1], min[1][i-1]) + input;
		}
		System.out.print(Math.max(max[0][N], Math.max(max[1][N], max[2][N])) + " " + Math.min(min[0][N], Math.min(min[1][N], min[2][N])));
	}
}