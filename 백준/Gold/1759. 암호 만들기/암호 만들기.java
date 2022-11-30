import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[] alpha = new char[C];
		alpha = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(alpha);
		
		StringBuilder sb = new StringBuilder();
		char[] result = new char[L];
		comb(alpha, result, 0, 0, 0, 0, L, C, sb);
		System.out.println(sb.toString());
	}
	
	public static void comb(char[] alpha, char[] result, int mo, int ja, int idxA, int idxR, int L, int C, StringBuilder sb) {
		if(idxR == L) {
			if(ja >= 2 && mo >=1) {
				for(char i : result) sb.append(i);
				sb.append("\n");
			}
			return;
		}
		
		for(int i = idxA; C - i >= L - idxR; i++) {
			result[idxR] = alpha[i];
			switch(alpha[i]) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				comb(alpha, result, mo + 1, ja, i + 1, idxR + 1, L, C, sb);
				break;
			default:
				comb(alpha, result, mo, ja + 1, i + 1, idxR + 1, L, C, sb);
			}
		}
	}
}