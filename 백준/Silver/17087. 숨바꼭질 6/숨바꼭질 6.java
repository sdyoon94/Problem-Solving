public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int S = read();
        int GCD = Math.abs(S - read());
        for (int i = 1; i < N; i++) {
            GCD = GCD(GCD, Math.abs(S - read()));
        }
        System.out.println(GCD);
    }

    public static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}