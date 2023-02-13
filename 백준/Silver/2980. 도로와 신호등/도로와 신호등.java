import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        TrafficLight[] tl = new TrafficLight[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            tl[i] = new TrafficLight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int wait = 0;
        for (int i = 0; i < N; i++) {
            int cnt = tl[i].R - (tl[i].D + wait) % tl[i].cycle;
            if (cnt > 0) wait += cnt;
        }
        System.out.println(L + wait);
    }

    public static class TrafficLight {
        int D;
        int R;
        int cycle;

        public TrafficLight(int D, int R, int G) {
            this.D = D;
            this.R = R;
            this.cycle = R + G;
        }
    }
}