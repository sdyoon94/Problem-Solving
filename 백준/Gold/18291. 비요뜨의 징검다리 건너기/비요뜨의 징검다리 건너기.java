import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(pow(N - 2)).append("\n");
        }
        System.out.println(sb);
    }

    public static long pow(int n) {
        if (n < 1) {
            return 1;
        }
        long tmp = pow(n / 2);
        if ((n & 1) == 0) {
            return tmp * tmp % MOD;
        }
        return tmp * tmp % MOD * 2 % MOD;
    }
}