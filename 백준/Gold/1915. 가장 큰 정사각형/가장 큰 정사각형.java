import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                if (input.charAt(j - 1) == '1' && (arr[i][j] = Integer.min(arr[i - 1][j - 1], Integer.min(arr[i - 1][j], arr[i][j - 1])) + 1) > ans) {
                    ans = arr[i][j];
                }
            }
        }
        System.out.println(ans * ans);
    }
}