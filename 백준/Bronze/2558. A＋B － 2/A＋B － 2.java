import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = Integer.parseInt(br.readLine());
        ans += Integer.parseInt(br.readLine());
        System.out.print(ans);
    }
}