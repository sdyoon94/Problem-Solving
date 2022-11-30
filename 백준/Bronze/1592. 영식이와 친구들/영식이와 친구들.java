import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] cnt = new int [N];
		int ans = 0;
		int current = 0;
		cnt[current]++;
		while(cnt[current]<M) {
			if(cnt[current]%2 == 0) {
				current += L;
			}else {
				current = current - L + N;
			}
			current %= N;
			cnt[current]++;
			ans++;
		}
		System.out.println(ans);
	}
}