import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    private static int ans1 = 0, ans2 = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);
        System.out.println(ans1 + " " + ans2);
    }

    public static void fib(int n){
        if(n==1||n==2){
            ans1++;
            return;
        }
        fib(n-1);
        fib(n-2);
    }

    public static void fibonacci(int n){
        int[] f = new int[n+1];
        f[1] = f[2] = 1;
        for(int i = 3; i <= n; i++){
            ans2++;
            f[i] = f[i-1] + f[i-2];
        }
    }
}
