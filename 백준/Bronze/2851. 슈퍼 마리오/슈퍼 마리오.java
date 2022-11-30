import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sum += tmp;
			if(sum>100) {
				sum = sum<<1 <= 200 + tmp ? sum : sum-tmp;
				break;
			}
		}
		System.out.println(sum);
	}
}