import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max, ans = 0;
        while ((max = max()) != 0) {
            ans++;
            arr[0]++;
            arr[max]--;
        }
        System.out.println(ans);
    }

    public static int max() {
        int result = 0;
        for (int i = 1; i < N; i++) {
            if (arr[result] <= arr[i]) result = i;
        }
        return result;
    }
}