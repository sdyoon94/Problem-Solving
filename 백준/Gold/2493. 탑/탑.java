import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] tower = new int[N];
		int[] answer = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) tower[i] = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = N-1; i >= 0; i--) {
			while(!stack.empty()) {
				if(tower[i]>tower[stack.peek()]) {
					answer[stack.pop()] = i+1;
				}else break;
			}
			stack.push(i);
		}
		for(int i: answer) bw.write(i + " ");
		bw.close();
	}
}