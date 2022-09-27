import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static int ans;
    public static int recursion(String s, int l, int r){
        ans++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            ans = 0;
            sb.append(isPalindrome(br.readLine())).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
