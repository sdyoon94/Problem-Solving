import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean cap = false;
        String input = br.readLine();
        int ans = input.length();
        for (int i = 0; i < input.length(); i++) {
            if (cap ^ isCap(input.charAt(i))) {
                ans++;
                if (i < input.length() - 1 && cap ^ isCap(input.charAt(i + 1))) {
                    cap = !cap;
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean isCap(char ch) {
        return 'a' > ch || ch > 'z';
    }
}