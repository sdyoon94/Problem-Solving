import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        int r = 31, M = 1234567891;
        int sub = 'a' - 1;
        int ans = 0;
        long cur = 1;
        for (int i = 0; i < N; i++) {
            long tmp = ((input[i] - sub) * cur) % M;
            ans = (int) ((ans + tmp) % M);
            cur = (cur * r) % M;
        }
        System.out.println(ans);
    }
}