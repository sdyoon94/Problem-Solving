import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, NA, NB, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= N; tc++) {
            sb.append("Case #").append(tc).append(": ");
            T = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            NA = Integer.parseInt(st.nextToken());
            NB = Integer.parseInt(st.nextToken());
            PriorityQueue<Train> A = new PriorityQueue<>(Comparator.comparing(a -> a.dep));
            PriorityQueue<Train> B = new PriorityQueue<>(Comparator.comparing(a -> a.dep));
            PriorityQueue<Integer> returnA = new PriorityQueue<>();
            PriorityQueue<Integer> returnB = new PriorityQueue<>();
            for (int i = 0; i < NA; i++) {
                st = new StringTokenizer(br.readLine(), " :");
                A.add(new Train(Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken())));
            }
            for (int i = 0; i < NB; i++) {
                st = new StringTokenizer(br.readLine(), " :");
                B.add(new Train(Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken())));
            }
            Train fastA = A.peek();
            Train fastB = B.peek();
            int ansA = 0;
            int ansB = 0;
            while (!A.isEmpty() || !B.isEmpty()) {
                if (fastB != null && (fastA == null || fastA.dep >= fastB.dep)) {
                    if (!returnB.isEmpty() && returnB.peek() <= fastB.dep) {
                        returnB.poll();
                    } else {
                        ansB++;
                    }
                    returnA.add(fastB.arr + T);
                    B.poll();
                    fastB = B.peek();
                } else if (fastA != null && (fastB == null || fastA.dep < fastB.dep)) {
                    if (!returnA.isEmpty() && returnA.peek() <= fastA.dep) {
                        returnA.poll();
                    } else {
                        ansA++;
                    }
                    returnB.add(fastA.arr + T);
                    A.poll();
                    fastA = A.peek();
                }
            }
            sb.append(ansA).append(" ").append(ansB).append("\n");
        }
        System.out.println(sb);
    }

    public static class Train {
        int dep;
        int arr;

        public Train(int dep, int arr) {
            this.dep = dep;
            this.arr = arr;
        }
    }
}