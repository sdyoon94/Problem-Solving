import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, R, map[][], tmp[][];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while(R-- > 0) {
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				tmp = new int[N][M];
				for(int i = 0; i < N; i++) {
					tmp[i] = map[N - i - 1];
				}
				break;
			case 2:
				tmp = new int[N][M];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						tmp[i][j] = map[i][M - j - 1];
					}
				}
				break;
			case 3:
				swap();
				tmp = new int[N][M];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						tmp[i][j] = map[M - j - 1][i];
					}
				}
				break;
			case 4:
				swap();
				tmp = new int[N][M];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						tmp[N - i - 1][j] = map[j][i];
					}
				}
				break;
			case 5:
				tmp = new int[N][M];
				for(int i = 0; i < N/2; i++) {
					for(int j = 0; j < M/2; j++) {
						tmp[i][j+M/2] = map[i][j];
					}
					for(int j = M/2; j < M; j++) {
						tmp[i+N/2][j] = map[i][j];
					}
				}
				for(int i = N/2; i < N; i++) {
					for(int j = 0; j < M/2; j++) {
						tmp[i-N/2][j] = map[i][j];
					}
					for(int j = M/2; j < M; j++) {
						tmp[i][j-M/2] = map[i][j];
					}
				}
				break;
			case 6:
				tmp = new int[N][M];
				for(int i = 0; i < N/2; i++) {
					for(int j = 0; j < M/2; j++) {
						tmp[i+N/2][j] = map[i][j];
					}
					for(int j = M/2; j < M; j++) {
						tmp[i][j-M/2] = map[i][j];
					}
				}
				for(int i = N/2; i < N; i++) {
					for(int j = 0; j < M/2; j++) {
						tmp[i][j+M/2] = map[i][j];
					}
					for(int j = M/2; j < M; j++) {
						tmp[i-N/2][j] = map[i][j];
					}
				}
			}
			map = tmp;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void swap() {
		int t = M;
		M = N;
		N = t;
	}
}