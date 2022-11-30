import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			Edge[] edges = new Edge[M * 2 + W];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges[i * 2] = new Edge(A, B, w);
				edges[i * 2 + 1] = new Edge(B, A, w);
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				edges[M * 2 + i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						-Integer.parseInt(st.nextToken()));
			}
			String answer = "NO\n";
			int[] d = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M * 2 + W; j++) {
					if (d[edges[j].to] > d[edges[j].from] + edges[j].weight) {
						if (i == N) {
							answer = "YES\n";
							break;
						}
						d[edges[j].to] = d[edges[j].from] + edges[j].weight;
					}
				}
			}
			sb.append(answer);
		}
		System.out.print(sb.toString());
	}

	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
}