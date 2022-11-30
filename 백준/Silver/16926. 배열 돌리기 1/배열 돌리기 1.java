import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, map[][], data[][][], size, al[][];
	
	public static void main(String[] args) throws IOException{
		inputData();
		for(int i = 0; i < size; i++) snail(N-1-i*2, M-1-i*2, i);
		print();
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
	
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int depth = data[i][j][0];
				int size = al[depth].length;
				int index = (data[i][j][1] + R) % size;
				sb.append(al[depth][index]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void snail(int h, int w, int depth) {
		int x = depth, y = depth, index = 0;
		al[depth] = new int[(w+h)*2];
		for(int i = 0; i < w; i++) {
			data[y][x][0] = depth;
			data[y][x][1] = index;
			al[depth][index++] = map[y][x];
			x++;
		}
		for(int i = 0; i < h; i++) {
			data[y][x][0] = depth;
			data[y][x][1] = index;
			al[depth][index++] = map[y][x];
			y++;
		}
		for(int i = 0; i < w; i++) {
			data[y][x][0] = depth;
			data[y][x][1] = index;
			al[depth][index++] = map[y][x];
			x--;
		}
		for(int i = 0; i < h; i++) {
			data[y][x][0] = depth;
			data[y][x][1] = index;
			al[depth][index++] = map[y][x];
			y--;
		}
	}
	
	static void inputData() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		data = new int[N][M][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		size = Math.min(N, M) / 2;
		al = new int[size][];
	}
}
