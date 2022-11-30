import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for(int i = 0; i < R; i++) map[i] = br.readLine().toCharArray(); 
		boolean[] chk = new boolean['Z' - 'A' + 1];
		process(map, chk, 0, 0, 0);
		System.out.println(ans);
	}

	private static void process(char[][] map, boolean[] chk, int i, int j, int cnt) {
		try {
			if(chk[map[i][j] - 'A']) {
				if(ans < cnt) ans = cnt;
				return;
			}
			chk[map[i][j] - 'A'] = true;
			process(map, chk, i-1, j, cnt+1);
			process(map, chk, i, j-1, cnt+1);
			process(map, chk, i+1, j, cnt+1);
			process(map, chk, i, j+1, cnt+1);
			chk[map[i][j] - 'A'] = false;
		} catch(IndexOutOfBoundsException e) {}
	}
}