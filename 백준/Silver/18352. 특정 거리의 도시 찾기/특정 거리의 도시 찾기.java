import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			adj.add(new ArrayList<Integer>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			adj.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(X);
		boolean[] visit = new boolean[N + 1];
		visit[X] = true;
		int depth = 0;
		while (!q.isEmpty()) {
			if (depth == K)
				break;
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				for (int i : adj.get(cur)) {
					if (visit[i])
						continue;
					visit[i] = true;
					q.offer(i);
				}
			}
			depth++;
		}
		if (q.isEmpty())
			System.out.print(-1);
		else {
			int size = q.size();
			int[] ans = new int[size];
			for (int i = 0; i < size; i++)
				ans[i] = q.poll();
			Arrays.sort(ans);
			StringBuilder sb = new StringBuilder();
			for (int i : ans)
				sb.append(i).append("\n");
			System.out.println(sb.toString());
		}
	}
}