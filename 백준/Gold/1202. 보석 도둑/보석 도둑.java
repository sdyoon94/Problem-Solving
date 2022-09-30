import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Gem[] gems = new Gem[N];
        PriorityQueue<Gem> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            gems[i] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        Arrays.sort(gems, (a, b) -> {
            if (a.weight == b.weight) {
                return b.value - a.value;
            } else {
                return a.weight - b.weight;
            }
        });
        long ans = 0;
        int idx = 0;
        for (int i : bags) {
            while (idx < N && gems[idx].weight <= i) {
                pq.add(gems[idx++]);
            }
            if (!pq.isEmpty()) {
                ans += pq.poll().value;
            }
        }
        System.out.println(ans);
    }

    static class Gem {
        private int weight;
        private int value;

        Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
