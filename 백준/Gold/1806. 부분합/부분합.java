import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }
        int ans = bs(sum, S, 1, N);
        if (sum[N] < S) {
            ans = 0;
        } else {
            int end = ans--;
            while (end <= N) {
                if (sum[end] - sum[end - ans] >= S) {
                    ans--;
                }else {
                    end++;
                }
            }
            ans++;
        }
        System.out.println(ans);
    }

    public static int bs(int[] arr, int target, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target){
                return mid;
            } else if(arr[mid] < target){
                return bs(arr, target, mid + 1, end);
            } else{
                return bs(arr, target, start, mid);
            }
        }
        return start;
    }
}
