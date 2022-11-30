import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //노드의 개수
		boolean[] visit = new boolean[N+1]; // 노드 방문 체크
		int[] answer = new int[N+1]; // 해당 노드의 부모 번호 저장
		
		// N개의 노드에 대한 인접리스트 생성
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(N+1); 
		for(int i = 0; i <= N; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		// 간선 정보 입력
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj.get(A).add(B); // A 노드에서 갈 수 있는 지점으로 B 추가 
			adj.get(B).add(A); // B 노드에서 갈 수 있는 지점으로 A 추가
		}
		
		// DFS 탐색
		DFS(adj, 1, visit, answer);
		
		// 출력
		for(int i = 2; i <= N; i++) sb.append(answer[i]).append("\n");
		System.out.println(sb.toString());
	}
	
	public static void DFS(ArrayList<ArrayList<Integer>> adj, int current, boolean[] visit, int[] answer) {
		 for(int i : adj.get(current)) {
			 if(!visit[i]) {
				 visit[i] = true;
				 answer[i] = current;
				 DFS(adj, i, visit, answer);
			 }
		 }
	}
}
