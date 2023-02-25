import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int GCD = Math.abs(S - Integer.parseInt(st.nextToken()));
        for (int i = 1; i < N; i++) {
            GCD = GCD(GCD, Math.abs(S - Integer.parseInt(st.nextToken())));
        }
        System.out.println(GCD);
    }

    public static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}