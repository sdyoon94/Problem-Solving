import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())] = i;
        }
        int ans = 1;
        int cur = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i + 1]) {
                cur++;
            } else {
                if (ans < cur) ans = cur;
                cur = 1;
            }
        }
        if (ans < cur) ans = cur;
        System.out.println(N - ans);
    }
}