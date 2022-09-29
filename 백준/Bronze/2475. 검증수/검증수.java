import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int cur = Integer.parseInt(st.nextToken());
            sum += cur * cur;
        }
        System.out.println(sum % 10);
    }
}