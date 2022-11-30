import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(N-->0) {
			int[] A = new int[4];
			int[] B = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0, size = Integer.parseInt(st.nextToken()); i < size; i++) A[Integer.parseInt(st.nextToken())-1]++;
			st = new StringTokenizer(br.readLine());
			for(int i = 0, size = Integer.parseInt(st.nextToken()); i < size; i++) B[Integer.parseInt(st.nextToken())-1]++;
			char result = 'D';
			for(int i = 3; i >= 0; i--) {
				if(A[i]==B[i]) continue;
				result = A[i] > B[i] ? 'A' : 'B';
				break;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}