import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
        }
        int[] num = new int[M];
        for (int i = 0; i <= N; i++){
            num[sum[i]]++;
        }
        long ans = 0;
        for(int i = 0; i < M; i++){
            long tmp = num[i];
            ans += tmp * (tmp - 1) / 2;
        }
        System.out.println(ans);
    }
}
