import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] build = new int[N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                build[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>(N + 1);
            for (int i = 0; i <= N; i++) {
                al.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                al.get(b).add(a);
            }
            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];
            Arrays.fill(dp, -1);
            sb.append(getTime(dp, al, build, target)).append("\n");
        }
        System.out.print(sb);
    }

    public static int getTime(int[] dp, ArrayList<ArrayList<Integer>> al, int[] build, int target) {
        if (dp[target] != -1) {
        } else if (al.get(target).isEmpty()) {
            dp[target] = build[target];
        } else {
            int max = 0;
            for (int i : al.get(target)) {
                int cur = getTime(dp, al, build, i);
                if (max < cur) {
                    max = cur;
                }
            }
            dp[target] = max + build[target];
        }
        return dp[target];
    }
}
