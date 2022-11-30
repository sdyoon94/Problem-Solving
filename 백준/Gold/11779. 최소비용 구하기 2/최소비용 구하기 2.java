import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Node>> adj = new ArrayList<>(n + 1);
		StringTokenizer st;
		for (int i = 0; i <= n; ++i)
			adj.add(new ArrayList<>());
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			Node edge = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), new ArrayList<>());
			edge.route.add(from);
			adj.get(from).add(edge);
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.w - b.w);
		q.offer(new Node(start, 0, new ArrayList<>()));
		Node[] ans = new Node[n + 1];
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (ans[cur.to] == null || ans[cur.to].w > cur.w) {
				cur.route.add(cur.to);
				ans[cur.to] = cur;
				for (Node next : adj.get(cur.to)) {
					q.offer(new Node(next.to, cur.w + next.w, new ArrayList<>(cur.route)));
				}
			}
		}
		System.out.print(ans[goal].w + "\n" + ans[goal].route.size() + "\n");
		for (int i : ans[goal].route)
			System.out.print(i + " ");
	}

	static class Node {
		int to, w = Integer.MAX_VALUE;
		ArrayList<Integer> route;

		public Node(int to, int w, ArrayList<Integer> route) {
			this.to = to;
			this.w = w;
			this.route = route;
		}
	}
}