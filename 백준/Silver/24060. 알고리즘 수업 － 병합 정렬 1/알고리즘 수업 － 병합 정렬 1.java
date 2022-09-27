import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int N, K, arr[], ans = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, N - 1);
        System.out.println(ans);
    }

    public static void mergeSort(int start, int end) {
        if (ans != -1) {
            return;
        }
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    public static void merge(int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int[] tmp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (--K == 0) {
                if (arr[i] <= arr[j]) {
                    ans = arr[i];
                } else {
                    ans = arr[j];
                }
                return;
            }
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            if (--K == 0) {
                ans = arr[i];
                return;
            }
            tmp[k++] = arr[i++];
        }
        while (j <= end) {
            if (--K == 0) {
                ans = arr[j];
                return;
            }
            tmp[k++] = arr[j++];
        }
        i = start; k = 0;
        while(i <= end){
            arr[i++] = tmp[k++];
        }
    }
}
