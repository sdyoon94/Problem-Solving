import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dohwaji = new int[100][100];
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		StringTokenizer st;
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i = x; i < x+10; i++) {
				for(int j = y; j < y+10; j++) {
					if(dohwaji[i][j]==0) {
						dohwaji[i][j]++;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}
}