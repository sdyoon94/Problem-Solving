import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N+1];
		for(int i = 0; i <= N; i++) score[i] = -1;
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			score[tmp] = 0;
			q.offer(tmp);
		}
		int ans = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 1; i <= N; i = i<<1) {
				int tmp = cur^i;
				if(tmp > N || score[tmp]!=-1) continue;
				score[tmp] = score[cur] + 1;
				q.offer(tmp);
				ans = Math.max(ans, score[tmp]);
			}
		}
		System.out.println(ans);
	}
}
