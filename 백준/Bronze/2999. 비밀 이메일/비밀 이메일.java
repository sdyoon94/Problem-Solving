import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = input.length();
		int R = 1, C;
		for(int i = 2; i*i <= N; i++) if(N%i==0) R = i;
		C = N/R;
		char[][] word = new char[C][R];
		for(int i = 0; i < C; i++) for(int j = 0; j < R; j++) word[i][j] = input.charAt(i*R+j);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < R; i++) for(int j = 0; j < C; j++) sb.append(word[j][i]);
		System.out.println(sb.toString());
	}
}