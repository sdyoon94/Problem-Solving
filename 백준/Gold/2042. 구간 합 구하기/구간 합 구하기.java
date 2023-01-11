import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Main {
        private static long[] tree, arr;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(br.readLine());
            }
            int size = N * 2;
            if ((N & N - 1) != 0) tree = new long[N * 4];
            else tree = new long[N * 2];
            init(0, N - 1, 1);
            StringBuilder sb = new StringBuilder();
            while (K > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                if (Integer.parseInt(st.nextToken()) == 1) {
                    int index = Integer.parseInt(st.nextToken()) - 1;
                    long change = Long.parseLong(st.nextToken());
                    update(0, N - 1, 1, index, change - arr[index]);
                    arr[index] = change;
                } else {
                    sb.append(sum(0, N - 1, 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1)).append("\n");
                    K--;
                }
            }
            System.out.println(sb);
        }

        public static long init(int start, int end, int node) {
            if (start == end) return tree[node] = arr[start];

            int mid = (start + end) / 2;
            return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
        }

        public static long sum(int start, int end, int node, int left, int right) {
            if (right < start || end < left) return 0;

            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;
            return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
        }

        public static void update(int start, int end, int node, int index, long dif) {
            if (index < start || end < index) return;

            tree[node] += dif;
            if (start == end) return;

            int mid = (start + end) / 2;
            update(start, mid, node * 2, index, dif);
            update(mid + 1, end, node * 2 + 1, index, dif);
        }
    }