import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dc(0, N));
    }

    public static int GCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return GCD(b % a, a);
    }

    public static int GCDs(int a, int b) {
        int gcd = input[a];
        for (int i = a + 1; i < b; i++) {
            gcd = GCD(gcd, input[i]);
        }
        return gcd;
    }

    public static int dc(int start, int end) {
        if (end - start == 1) {
            return input[start];
        }
        int mid = (start + end) / 2;
        int gcdFront = GCDs(start, mid);
        int gcdEnd = GCDs(mid, end);
        return Integer.max(gcdFront + dc(mid, end), dc(start, mid) + gcdEnd);
    }
}