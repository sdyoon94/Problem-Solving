import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println("? " + 1000000000);
        System.out.flush();
        String answer = br.readLine();
        StringBuilder zero = new StringBuilder();
        while ((answer.length() + zero.length()) % 9 != 0) {
            zero.append(0);
        }
        answer = zero.toString() + answer;
        int[] ans = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            ans[i] = Integer.parseInt(answer.substring(i * 9, (i + 1) * 9));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("!").append(" ");
        for (int i = N; i >= 0; i--) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}