import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 신청한 동아리 수 (1 <= N <= 500,000)
		int S = Integer.parseInt(st.nextToken()); // 3명의 능력합 커트라인 (0 <= S <= 12,000)
		int M = Integer.parseInt(st.nextToken()); // 개인 능력 커트라인 (0 <= M <= 4,000)
		
		int ans = 0; // 가입 가능한 동아리 수
		ArrayList<Integer> al = new ArrayList<Integer>(N*3); // 가입된 학생들의 능력치
		for(int i = 0; i < N; i++) {
			int[] s = new int[3]; // 3명 능력치 저장
			int sum = 0, chk = 0; // 3명 능력 합계와 개별 통과 확인할 변수
			st = new StringTokenizer(br.readLine());
			// 3명의 능력치 입력
			for(int j = 0; j < 3; j++) {
				s[j] = Integer.parseInt(st.nextToken());
				sum += s[j]; // 합계에 더하기
				if(s[j] >= M) chk++; // 개인 커트라인 통과시 chk에 한명 추가
			}
			if(sum >= S && chk == 3) { // 능력합이 커트라인을 통과하고 개인 커트라인 통과자가 3명이면
				ans++; // 가입이 가능한 동아리 수 1추가
				al.add(s[0]); // 개별
				al.add(s[1]); // 능력치
				al.add(s[2]); // 저장
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append("\n"); // 첫째줄에 가입이 가능한 동아리의 수 출력
		for(int i : al) sb.append(i).append(" "); // 둘째 줄에 가입된 학생들의 능력치 출력
		sb.setLength(sb.length()-1); // 마지막 공백 삭제
		System.out.println(sb.toString()); // 출력
	}
}