import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine()); // 롤 케이크의 길이	(1 <= L <= 1000)
		int N = Integer.parseInt(br.readLine()); // 방청객의 수	(1 <= N <= 1000)
		boolean[] chk = new boolean[L+1];
		
		int s, e, ans1 = 1, ans2 = 1, many = 0, piece = 1, cur;
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			cur = 0;
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			if(e-s > many) {
				many = e-s;
				ans1 = i;
			}
			for(int j = s; j <= e; j++) {
				if(chk[j]) continue;
				chk[j] = true;
				cur++;
			}
			if(cur > piece) {
				piece = cur;
				ans2 = i;
			}
		}
		System.out.println(ans1 + "\n" + ans2);
	}
}