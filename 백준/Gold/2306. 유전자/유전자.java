import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static char[] input;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        int size = input.length;
        dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dp(0, size - 1));
    }

    public static int dp(int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] == -1) {
            for (int i = start; i < end; i++) {
                dp[start][end] = Math.max(dp[start][end], dp(start, i) + dp(i + 1, end));
            }
            if (input[start] == 'a' && input[end] == 't' || input[start] == 'g' && input[end] == 'c') {
                dp[start][end] = Math.max(dp[start][end], dp(start + 1, end - 1) + 2);
            }
        }
        return dp[start][end];
    }
}