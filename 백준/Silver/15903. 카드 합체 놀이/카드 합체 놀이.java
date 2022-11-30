import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n, m, size;
	private static long[] heap;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 카드 개수
		m = Integer.parseInt(st.nextToken()); // 카드 합체 횟수
		
		// min heap 구현
		heap = new long[n+1];
		size = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			push(Integer.parseInt(st.nextToken()));
		}
		
		// 카드합체 m번 반복
		long tmp;
		while(m-->0) {
			tmp = pop() + pop();
			push(tmp);
			push(tmp);
		}
		
		// 합계 출력
		long sum = 0;
		for(int i = 1; i <= n; i++) sum+=heap[i];
		System.out.println(sum);
	}
	
	public static void push(long a) {
		heap[++size] = a;
		int current = size;
		while(current != 1 && heap[current/2] > heap[current]) {
			swap(current, current/2);
			current = current/2;
		}
	}
	
	public static long pop() {
		swap(1, size);
		int current = 1;
		while(current*2 < size) {
			int child;
			if(current*2+1 >= size) child = current*2;
			else child = heap[current*2] < heap[current*2+1] ? current*2 : current*2+1;
			if(heap[current] < heap[child]) break;
			swap(current, child);
			current = child;
		}
		return heap[size--];
	}
	
	public static void swap(int a, int b) {
		long tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
}