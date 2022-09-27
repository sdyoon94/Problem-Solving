import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] sum = new int[26][input.length() + 1];
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 0; j < 26; j++) {
                sum[j][i] = sum[j][i - 1];
            }
            sum[input.charAt(i - 1) - 'a'][i]++;
        }
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[c][end + 1] - sum[c][start]).append("\n");
        }
        System.out.print(sb);
    }
}
