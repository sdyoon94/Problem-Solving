import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] w = new int[N];
		for(int i = 0; i < N; i++) w[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(w);
		if(w[0]!=1) {
			System.out.println(1);
			return;
		}
		int sum = 1;
		for(int i = 1; i < N; i++) {
			if(sum + 1 < w[i]) break;
			sum += w[i];
		}
		System.out.println(sum + 1);
	}
}