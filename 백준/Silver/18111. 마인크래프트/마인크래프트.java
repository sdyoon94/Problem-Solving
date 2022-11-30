import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int time = Integer.MAX_VALUE;
		int height = 0;
		int[] cnt = new int[257];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				cnt[Integer.parseInt(st.nextToken())]++;
			}
		}
		
		for(int h = 256; h >= 0; h--) {
			int req = 0;
			int t = 0;
			for(int i = 256; i >= 0; i--) {
				int tmp = (h - i) * cnt[i];
				if(tmp == 0) continue;
				req += tmp;
				t += (tmp < 0) ? 2 * -tmp : tmp;
				if(t > time) break;
			}
			if(req <= B && t < time) {
				time = t;
				height = h;
			}
		}
		System.out.println(time + " " + height);
	}
}