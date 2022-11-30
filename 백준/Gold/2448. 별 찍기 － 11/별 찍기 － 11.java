import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N*2-1];
		for(int i = 0; i < N; i++) Arrays.fill(map[i], ' ');
		star(map, 0, 0, N);
		for(int i = 0; i < N; i++) {
			bw.write(map[i]);
			bw.write("\n");
		}
		bw.close();
	}
	public static void star(char[][] map, int r, int c, int N) {
		if(N==3) {
			map[r][c+2] = map[r+1][c+1] = map[r+1][c+3] = map[r+2][c] = map[r+2][c+1] = map[r+2][c+2] = map[r+2][c+3] = map[r+2][c+4] = '*';
			return;
		}
		star(map, r, c + N/2, N/2);
		star(map, r + N/2, c, N/2);
		star(map, r + N/2, c + N, N/2);
	}
}