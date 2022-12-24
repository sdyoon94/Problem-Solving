import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[1000001];
        for (int i = 3; i <= 1000000; i += 2) {
            isPrime[i] = true;
        }
        isPrime[2] = true;
        for (int i = 3; i <= 1000; i += 2) {
            if (isPrime[i]) {
                for (int j = i; i * j <= 1000000; j += 2) {
                    isPrime[i * j] = false;
                }
            }
        }
        int[] prime = new int[1000001];
        int[] square = new int[1000001];
        square[2] = prime[2] = 1;
        for (int i = 3; i <= 1000000; i++) {
            prime[i] = prime[i - 1];
            square[i] = square[i - 1];
            if (isPrime[i]) {
                prime[i]++;
                if ((i & 3) == 1) {
                    square[i]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            if (L == -1 && U == -1) {
                break;
            }
            sb.append(L).append(" ").append(U).append(" ");
            if (U < 2) {
                sb.append(0).append(" ").append(0);
            } else if (L < 1) {
                sb.append(prime[U]).append(" ").append(square[U]);
            } else {
                sb.append(prime[U] - prime[L - 1]).append(" ").append(square[U] - square[L - 1]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}