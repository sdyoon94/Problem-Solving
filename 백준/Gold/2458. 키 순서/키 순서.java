import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 학생들의 수 (2 ≤ N ≤ 500)
			int M = Integer.parseInt(st.nextToken());	// 비교 횟수 (0 ≤ M ≤ N*(N-1)/2)
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>(N + 1);	// 인접리스트 생성
			for (int i = 0; i <= N; ++i)
				adj.add(new ArrayList<>());
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				adj.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));	// 작은 학생의 리스트에 큰 학생 번호 추가
			}
			
			int[] count = new int[N + 1];	// 나보다 작은 학생의 수 + 나보다 큰 학생의 수
			Queue<Integer> q = new ArrayDeque<>();	// BFS를 위한 큐 생성
			for (int i = 1; i <= N; ++i) {	// 모든 학생에 대해 BFS 실행
				q.add(i);
				boolean[] visit = new boolean[N + 1];
				visit[i] = true;
				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int next : adj.get(cur)) {
						if (visit[next])	// 중복 방지
							continue;
						visit[next] = true;	// 중복 방지
						++count[next];	// 큰 학생보다 작은 학생의 수 1 추가
						++count[i];	
						// 나보다 큰 학생 수 1 추가
						q.offer(next);
					}
				}
			}
			int ans = 0;	//
			for (int i = 1; i <= N; ++i)
				if (count[i] == N - 1)	// 나보다 작은 학생의 수 + 나보다 큰 학생의 수가 N - 1이면 정답 추가
					ans++;
		System.out.print(ans);
	}
}