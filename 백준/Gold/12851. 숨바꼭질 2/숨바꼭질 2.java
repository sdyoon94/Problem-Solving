import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] visit = new int[100001];
		Arrays.fill(visit, Integer.MAX_VALUE);
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(N);
		int ans = 0, time = -1;
		while (ans == 0) {
			time++;
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				if(cur == K) {
					ans++;
					continue;
				}
				if (cur < 0 || cur > 100000 || visit[cur] < time)
					continue;
				visit[cur] = time;
				q.offer(cur - 1);
				q.offer(cur + 1);
				q.offer(cur * 2);
			}
		}
		System.out.print(time + "\n" + ans);
	}
}