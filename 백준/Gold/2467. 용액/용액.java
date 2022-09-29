import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = N - 1;
        int min = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;
        while (left < right) {
            int cur = arr[left] + arr[right];
            if (Math.abs(cur) < min) {
                min = Math.abs(cur);
                ans1 = arr[left];
                ans2 = arr[right];
            }
            if (cur == 0) {
                break;
            } else if (cur < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}