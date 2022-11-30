import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int K = Integer.parseInt(st.nextToken());
		int index = K - 1;
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		sb.append("<").append(arr[index]);
		System.arraycopy(arr, index+1, arr, index, --N - index);
		while(N>0) {
			index = (index + K - 1) % N;
			sb.append(", ").append(arr[index]);
			System.arraycopy(arr, index+1, arr, index, --N - index);
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}
