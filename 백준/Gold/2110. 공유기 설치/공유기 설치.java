import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int C;
    private static int[] house;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        int left = 0, right = 1000000000;
        while (left != right) {
            int mid = (left + right + 1) / 2;
            if (count(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    public static boolean count(int distance) {
        int cnt = 1, cur = house[1];
        for (int i = 2; i <= N; i++) {
            if (house[i] - cur >= distance) {
                cnt++;
                if (cnt == C) return true;
                cur = house[i];
            }
        }
        return false;
    }
}