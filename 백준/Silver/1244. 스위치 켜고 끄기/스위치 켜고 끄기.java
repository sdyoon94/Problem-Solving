import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] swc = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			swc[i] = Integer.parseInt(st.nextToken());
		}
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				int num = Integer.parseInt(st.nextToken());
				for(int i = num-1; i < N; i+=num) swc[i] = 1 - swc[i];
				break;
			case 2:
				int i = Integer.parseInt(st.nextToken()) - 1;
				int j = i;
				while(i>=0 && j <N && swc[i] == swc[j]) {
					swc[i] = 1 - swc[i];
					swc[j++] = swc[i--];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N/20; i++) {
			for(int j = i*20; j < (i+1)*20; j++) {
				sb.append(swc[j]).append(" ");
			}
			sb.append("\n");
		}
		for(int i = (N/20)*20; i < N; i++) sb.append(swc[i]).append(" ");
		System.out.println(sb.toString());
	}
}
