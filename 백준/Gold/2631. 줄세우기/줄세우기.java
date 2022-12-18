import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[N];
        int[] X = new int[N + 1];
        Arrays.fill(X, Integer.MAX_VALUE);
        X[0] = 0;
        X[1] = input[0];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < N; i++) {
            int left = 0, right = N + 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (X[mid] > input[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            dp[i] = left;
            if (X[left] == Integer.MAX_VALUE) {
                ans = left;
            }
            X[left] = input[i];
        }
        System.out.println(N - ans);
    }
}