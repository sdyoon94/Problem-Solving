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
            PriorityQueue<Time> returnA = new PriorityQueue<>();
            PriorityQueue<Time> returnB = new PriorityQueue<>();
            for (int i = 0; i < NA; i++) {
                st = new StringTokenizer(br.readLine(), " :");
                A.add(new Train(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            for (int i = 0; i < NB; i++) {
                st = new StringTokenizer(br.readLine(), " :");
                B.add(new Train(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Train fastA = A.peek();
            Train fastB = B.peek();
            int ansA = 0;
            int ansB = 0;
            while (!A.isEmpty() || !B.isEmpty()) {
                if (fastB != null && (fastA == null || fastA.dep.compareTo(fastB.dep) >= 0)) {
                    if (!returnB.isEmpty() && returnB.peek().compareTo(fastB.dep) <= 0) {
                        returnB.poll();
                    }else{
                        ansB++;
                    }
                    fastB.arr.returnTrain();
                    returnA.add(fastB.arr);
                    B.poll();
                    fastB = B.peek();
                } else if (fastA != null && (fastB == null || fastA.dep.compareTo(fastB.dep) < 0)) {
                    if (!returnA.isEmpty() && returnA.peek().compareTo(fastA.dep) <= 0) {
                        returnA.poll();
                    }else{
                        ansA++;
                    }
                    fastA.arr.returnTrain();
                    returnB.add(fastA.arr);
                    A.poll();
                    fastA = A.peek();
                }
            }
            sb.append(ansA).append(" ").append(ansB).append("\n");
        }
        System.out.println(sb);
    }

    public static class Time implements Comparable<Time> {
        int hour;
        int min;

        public Time(int hour, int min) {
            this.hour = hour;
            this.min = min;
        }

        public void returnTrain() {
            this.min += T;
            if (this.min >= 60) {
                this.hour++;
                this.min -= 60;
            }
        }

        @Override
        public int compareTo(Time o) {
            if (this.hour == o.hour) {
                return this.min - o.min;
            } else {
                return this.hour - o.hour;
            }
        }
    }

    public static class Train {
        Time dep;
        Time arr;

        public Train(int depHour, int depMin, int arrHour, int arrMin) {
            this.dep = new Time(depHour, depMin);
            this.arr = new Time(arrHour, arrMin);
        }
    }
}