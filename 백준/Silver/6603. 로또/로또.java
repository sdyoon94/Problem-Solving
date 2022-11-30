import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			int[] num = new int[k];
			for(int i = 0; i < k; i++) num[i] = Integer.parseInt(st.nextToken());
			boolean[] visit = new boolean[k];
			comb(num, visit, sb, 0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void comb(int[] list, boolean[] visit, StringBuilder sb, int index, int r) {
		if(r == 6) {
			for(int i = 0, size = list.length; i < size; i++) if(visit[i]) sb.append(list[i]).append(" ");
			sb.append("\n");
			return;
		}
		for(int i = index, size = list.length; i < size; i++) {
			visit[i] = true;
			comb(list, visit, sb, i+1, r+1);
			visit[i] = false;
		}
	}
}