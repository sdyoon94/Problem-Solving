import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final loc[] num = new loc[26];
    private static final int[] row = {5, 5, 5, 5, 5};
    private static final int[] col = {5, 5, 5, 5, 5};
    private static int RB = 5;
    private static int LB = 5;
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                num[Integer.parseInt(st.nextToken())] = new loc(i, j);
            }
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int MC = Integer.parseInt(st.nextToken());
                int r = num[MC].r;
                int c = num[MC].c;
                if (--row[r] == 0) {
                    ans++;
                }
                if (--col[c] == 0) {
                    ans++;
                }
                if (r == c && --RB == 0) {
                    ans++;
                }
                if (r + c == 4 && --LB == 0) {
                    ans++;
                }
                if (ans > 2) {
                    System.out.println(i * 5 + j + 1);
                    return;
                }
            }
        }
    }

    public static class loc {
        private int r, c;

        public loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}