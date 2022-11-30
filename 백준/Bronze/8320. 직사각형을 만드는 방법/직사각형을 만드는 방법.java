import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = n;
		for(int i = 2; i*i <= n; i++) ans += n/i - (i-1);
		System.out.println(ans);
	}
}