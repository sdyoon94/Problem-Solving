import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[] cake = new int[N];
            for (int i = 0; i < N; i++) {
                cake[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = N; i > 1; i--) {
                int loc = 0;
                for (int j = 0; j < N; j++) {
                    if (Math.abs(cake[j]) == i) {
                        loc = j;
                        break;
                    }
                }
                if (loc + 1 == i && cake[loc] > 0) {
                    continue;
                }
                if (loc != 0) {
                    ans.add(loc + 1);
                    flip(cake, loc);
                }
                if (cake[0] > 0) {
                    ans.add(1);
                }
                ans.add(i);
                flip(cake, i - 1);
            }
            if (cake[0] < 0) {
                ans.add(1);
            }
            sb.append(ans.size());
            for (int i : ans) {
                sb.append(" ").append(i);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void flip(int[] cake, int loc) {
        for (int i = 0; i <= loc / 2; i++) {
            int tmp = -cake[i];
            cake[i] = -cake[loc - i];
            cake[loc - i] = tmp;
        }
    }
}