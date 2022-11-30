import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 노드 개수
		int m = Integer.parseInt(br.readLine()); // 간선 개수
		
		// 인접리스트 생성
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n+1);
		for(int i = 0; i <= n; i++) adj.add(new ArrayList<Integer>());
		// 간선 연결
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj.get(A).add(B);
			adj.get(B).add(A);
		}
		// BFS 탐색
		int answer = 0, depth = 0;
		boolean[] visit = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visit[1] = true;
		while(!q.isEmpty() && depth < 2) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int current = q.poll();
				for(int j : adj.get(current)) {
					if(visit[j]) continue;
					visit[j]=true;
					answer++;
					q.offer(j);
				}
			}
			depth++;
		}
		System.out.println(answer);
	}
}