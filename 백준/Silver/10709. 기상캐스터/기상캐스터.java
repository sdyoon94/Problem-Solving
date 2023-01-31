import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            int cur = -1;
            for (int j = 0; j < W; j++) {
                if (input.charAt(j) == 'c') {
                    cur = 0;
                } else if (cur != -1) {
                    cur++;
                }
                sb.append(cur).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}