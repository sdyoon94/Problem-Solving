import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringBuilder sb = new StringBuilder();
		while(!(input = br.readLine()).equals("0")) {
			int i = 0, j = input.length() - 1;
			String ans = "yes\n";
			while(i<j) {
				if(input.charAt(i++)!=input.charAt(j--)) {
					ans = "no\n";
					break;
				}
			}
			sb.append(ans);
		}
		System.out.println(sb.toString());
	}
}