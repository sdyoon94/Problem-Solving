import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pq.offer(new Edge(st.nextToken(), st.nextToken(), st.nextToken()));
        }
        int[] root = new int[N + 1];
        for (int i = 1; i <= N; i++) root[i] = i;
        int group = N;
        int ans = 0;
        while (group > 2) {
            Edge cur = pq.poll();
            if (union(root, cur.a, cur.b)) {
                group--;
                ans += cur.cost;
            }
        }
        System.out.println(ans);
    }

    public static boolean union(int[] root, int a, int b) {
        int rootA = findRoot(root, a);
        int rootB = findRoot(root, b);
        if (rootA == rootB) {
            return false;
        } else {
            root[rootA] = rootB;
            return true;
        }
    }

    public static int findRoot(int[] root, int a) {
        if (root[a] == a) {
            return a;
        } else {
            return root[a] = findRoot(root, root[a]);
        }
    }

    public static class Edge {
        int a, b, cost;

        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        Edge(String a, String b, String cost) {
            this.a = Integer.parseInt(a);
            this.b = Integer.parseInt(b);
            this.cost = Integer.parseInt(cost);
        }
    }
}