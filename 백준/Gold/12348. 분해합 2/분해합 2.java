import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long length = input.length();
        long N = Long.parseLong(input);
        for (long i = N - length * 9; i < N; i++) {
            if (sum(i) == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    public static long sum(long i) {
        long result = i;
        while (i > 0) {
            result += i % 10;
            i /= 10;
        }
        return result;
    }
}