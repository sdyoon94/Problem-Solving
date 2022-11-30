import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Node[] adj = new Node[N + 1];
		StringTokenizer st;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp = Integer.parseInt(st.nextToken());
			adj[tmp] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), adj[tmp]);
		}
		int start, end;
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> q = new PriorityQueue<>();
		int[] d = new int[N+1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(d, INF);
		d[start] = 0;
		q.offer(new Node(start, 0, null));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.num == end) break;
			if(d[cur.num] < cur.weight) continue;
			for(Node node = adj[cur.num];node!=null;node=node.next) {
				if(d[node.num] > cur.weight + node.weight) {
					d[node.num] = cur.weight + node.weight;
					q.offer(new Node(node.num, cur.weight + node.weight, null));
				}
			}
		}
		System.out.print(d[end]);
	}
	static class Node implements Comparable<Node> {
		int num, weight;
		Node next;

		public Node(int num, int weight, Node next) {
			super();
			this.num = num;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
}