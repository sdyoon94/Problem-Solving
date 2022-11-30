import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Node>> adj = new ArrayList<>();
		for (int i = 0; i <= V; i++)
			adj.add(new ArrayList<Node>());
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			adj.get(Integer.parseInt(st.nextToken()))
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		PriorityQueue<Node> q = new PriorityQueue<Node>();
		int[] d = new int[V + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(d, INF);
		q.offer(new Node(K, 0));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (d[cur.to] != INF)
				continue;
			d[cur.to] = cur.w;
			for (Node i : adj.get(cur.to))
				if (d[i.to] == INF)
					q.offer(new Node(i.to, d[cur.to] + i.w));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (d[i] == INF)
				sb.append("INF");
			else
				sb.append(d[i]);
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static class Node implements Comparable<Node> {
		int to, w;

		public Node(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}
}