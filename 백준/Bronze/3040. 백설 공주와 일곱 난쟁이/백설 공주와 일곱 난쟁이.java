import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = -100;
		int[] dwarf = new int[9];
		for(int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum+=dwarf[i];
		}
		for(int i = 0; i < 9; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(dwarf[i]+dwarf[j] == sum) {
					StringBuilder sb = new StringBuilder();
					for(int k = 0; k < 9; k++) {
						if(k==i || k==j) continue;
						sb.append(dwarf[k]).append("\n");
					}
					System.out.println(sb.toString());
					return;
				}
			}
		}
	}
}