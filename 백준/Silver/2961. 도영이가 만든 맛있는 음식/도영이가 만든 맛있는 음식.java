import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 재료의 개수
		int[][] taste = new int[N][2]; // 재료의 신맛과 쓴맛
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0, sour = 1, bitter = 0;
		System.out.println(permu(taste, N, index, sour, bitter));
	}

	private static int permu(int[][] taste, int n, int index, int sour, int bitter) {
		if(index == n) {
			if(bitter==0) return Integer.MAX_VALUE;
			else return Math.abs(sour - bitter);
		}
		return Math.min(permu(taste, n, index+1, sour, bitter), permu(taste, n, index+1, sour*taste[index][0], bitter + taste[index][1]));
	}
}