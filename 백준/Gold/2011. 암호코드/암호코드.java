import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        int[] dp = new int[length + 1];
        dp[0] = dp[1] = 1;
        if (length == 0 || input.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        for (int i = 1; i < length; i++) {
            dp[i + 1] = dp[i];
            switch (input.charAt(i)) {
                case '0':
                    if (input.charAt(i - 1) != '1' && input.charAt(i - 1) != '2') {
                        System.out.println(0);
                        return;
                    }
                    dp[i + 1] = 0;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                    if (input.charAt(i - 1) == '2') dp[i + 1] += dp[i - 1];
                case '7':
                case '8':
                case '9':
                    if (input.charAt(i - 1) == '1') dp[i + 1] += dp[i - 1];
            }
            if (dp[i + 1] > MOD) dp[i + 1] -= MOD;
        }
        System.out.println(dp[length]);
    }
}