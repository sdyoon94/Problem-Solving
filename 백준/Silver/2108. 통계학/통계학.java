import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double sum = 0;
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            sum += input;
            arr[i] = input;
        }
        Arrays.sort(arr);
        int ans = 0;
        int max = 0;
        int cnt = 1;
        boolean isSecond = false;
        for(int i = 1; i < N; i++) {
            if(arr[i] == arr[i-1]){
                cnt++;
            } else{
                if(cnt > max){
                    ans = arr[i-1];
                    max = cnt;
                    isSecond = false;
                } else if(cnt == max && !isSecond){
                    ans = arr[i-1];
                    isSecond = true;
                }
                cnt = 1;
            }
        }
        if(cnt > max || (cnt == max && !isSecond)){
            ans = arr[N-1];
        }
        System.out.println(Math.round(sum/N));
        System.out.println(arr[N/2]);
        System.out.println(ans);
        System.out.println(arr[N-1]-arr[0]);
    }
}