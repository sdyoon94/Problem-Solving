import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] item = new int[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++)
			item[i] = Integer.parseInt(st.nextToken());
		Node[] adj = new Node[n + 1];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			adj[a] = new Node(b, l, adj[a]);
			adj[b] = new Node(a, l, adj[b]);
		}

		PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.w - b.w);
		int[] d = new int[n + 1];
		int ans = 0, it;
		final int max = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			it = 0;
			Arrays.fill(d, max);
			q.offer(new Node(i, 0, null));
			while (!q.isEmpty()) {
				Node cur = q.poll();
				if (d[cur.to] != max)
					continue;
				d[cur.to] = cur.w;
				it += item[cur.to];
				for (Node next = adj[cur.to]; next != null; next = next.next) {
					int weight = cur.w + next.w;
					if (weight > m || d[next.to] != max)
						continue;
					q.offer(new Node(next.to, weight, null));
				}
			}
			if (ans < it)
				ans = it;
		}
		System.out.print(ans);
	}

	static class Node {
		int to, w;
		Node next;

		public Node(int to, int w, Node next) {
			this.to = to;
			this.w = w;
			this.next = next;
		}
	}
}