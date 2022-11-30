import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int max = 100001;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[max];
		q.offer(N);
		int time = -1;
		while (!q.isEmpty()) {
			time++;
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				if(cur == K) {
					System.out.print(time);
					return;
				}
				if (cur < 0 || cur >= max || visit[cur])
					continue;
				visit[cur] = true;
				q.offer(cur-1);
				q.offer(cur+1);
				q.offerFirst(cur<<1);
				size++;
			}
		}
	}
}