import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "";
		
		while((input = br.readLine())!=null) {
			String[] srr = input.split(" ");
			String ans = "No\n";
			int index = 0;
			
			for(int i = 0; i < srr[1].length(); i++) {
				if(srr[1].charAt(i) == srr[0].charAt(index)) {
					index++;
					if(index == srr[0].length()) {
						ans = "Yes\n";
						break;
					}
				}
			}
			sb.append(ans);
		}
		System.out.println(sb.toString());
	}
}
