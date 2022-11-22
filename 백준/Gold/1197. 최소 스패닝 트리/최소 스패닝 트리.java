import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int ans = 0;
        int cnt = V - 1;
        int[] root = new int[V + 1];
        for (int i = 1; i <= V; i++) root[i] = i;
        PriorityQueue<Edge> q = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            q.offer(new Edge(A, B, weight));
        }
        while (cnt > 0) {
            Edge edge = q.poll();
            int rootA = findRoot(root, edge.a);
            int rootB = findRoot(root, edge.b);
            if (rootA == rootB) continue;
            root[rootB] = rootA;
            ans += edge.weight;
            cnt--;
        }
        System.out.println(ans);
    }

    public static int findRoot(int[] root, int i) {
        if (root[i] == i) return i;
        else return root[i] = findRoot(root, root[i]);
    }

    static class Edge {
        int a, b, weight;

        Edge(int a, int b, int weight){
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }
}