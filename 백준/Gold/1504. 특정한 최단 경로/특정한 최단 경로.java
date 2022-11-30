import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int INF = 100000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Node[] adj = new Node[N + 1];
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			adj[A] = new Node(B, C, adj[A]);
			adj[B] = new Node(A, C, adj[B]);
		}
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int[] d1 = new int[N + 1];
		int[] d2 = new int[N + 1];
		int[] d3 = new int[N + 1];
		dijkstra(adj, d1, 1, v1, v2);
		dijkstra(adj, d2, v1, v2, N);
		dijkstra(adj, d3, v2, v1, N);
		int ans = Math.min(d1[v1] + d2[v2] + d3[N], d1[v2] + d3[v1] + d2[N]);
		System.out.print(ans < INF ? ans : -1);
	}

	static void dijkstra(Node[] adj, int[] d, int start, int des1, int des2) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		Arrays.fill(d, INF);
		d[start] = 0;
		for (Node node = adj[start]; node != null; node = node.next)
			q.offer(node);
		while (!q.isEmpty()) {
			if (d[des1] != INF && d[des2] != INF)
				return;
			Node cur = q.poll();
			if (d[cur.to] != INF)
				continue;
			d[cur.to] = cur.w; 
			for (Node node = adj[cur.to]; node != null; node = node.next) {
				if (d[node.to] != INF)
					continue;
				q.offer(new Node(node.to, cur.w + node.w));
			}
		}
	}

	static class Node implements Comparable<Node> {
		int to, w;
		Node next;

		public Node(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}

		public Node(int to, int w, Node next) {
			super();
			this.to = to;
			this.w = w;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}
}