import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		Node[] adj = new Node[V + 1];
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			while (to != -1) {
				int w = Integer.parseInt(st.nextToken());
				adj[num] = new Node(adj[num], w, to);
				to = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visit = new boolean[V + 1];
		dfs(adj, visit, 1);
		System.out.print(ans);
	}

	static int dfs(Node[] adj, boolean[] visit, int cur) {
		visit[cur] = true;
		int fst = 0, snd = 0, d = 0;
		for (Node node = adj[cur]; node != null; node = node.next)
			if (!visit[node.to]) {
				d = dfs(adj, visit, node.to) + node.w;
				if (d > fst) {
					snd = fst;
					fst = d;
				} else if (d > snd)
					snd = d;
			}
		if(ans < fst+snd) ans = fst+snd;
		return fst;
	}

	static class Node {
		Node next;
		int w, to;

		public Node(Node next, int w, int to) {
			super();
			this.next = next;
			this.w = w;
			this.to = to;
		}
	}
}
