import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			int[][] rec = new int[2][4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) for(int k = 0; k < 4; k++) rec[j][k] = Integer.parseInt(st.nextToken());
			if(rec[0][0] > rec[1][0]) {
				int[] tmp = rec[0];
				rec[0] = rec[1];
				rec[1] = tmp;
			}
			if(rec[0][2] < rec[1][0] || rec[0][1] > rec[1][3] || rec[0][3] < rec[1][1]) sb.append("d");
			else if((rec[0][1]==rec[1][3]||rec[0][3]==rec[1][1])&&rec[0][2]==rec[1][0]) sb.append("c");
			else if(rec[0][1]==rec[1][3]||rec[0][3]==rec[1][1]||rec[0][2]==rec[1][0]) sb.append("b");
			else sb.append("a");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}