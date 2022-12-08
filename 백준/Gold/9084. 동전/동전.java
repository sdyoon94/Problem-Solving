import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int goal = Integer.parseInt(br.readLine());
            int[] dp = new int[goal + 1];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < goal && j + coin[i] <= goal; j++) {
                    dp[j + coin[i]] += dp[j];
                }
            }
            sb.append(dp[goal]).append("\n");
        }
        System.out.println(sb);
    }
}