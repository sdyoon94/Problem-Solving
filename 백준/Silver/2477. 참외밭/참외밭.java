import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int h = 0;
		int w = 0;
		int[][] input = new int[6][2];
		StringTokenizer st;
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			if(input[i][0] > 2 && h < input[i][1]) h = input[i][1];
			else if(input[i][0] < 3 && w < input[i][1]) w = input[i][1];
		}
		for(int i = 0; i < 6; i++) {
			if(input[i][0] == input[(i+2)%6][0] && input[(i+1)%6][0] == input[(i+3)%6][0]) {
				System.out.println(K*(h*w - input[(i+1)%6][1]*input[(i+2)%6][1]));
				return;
			}
		}
	}
}