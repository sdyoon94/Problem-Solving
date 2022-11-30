import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 2번째 문제 시작
	public static void main(String[] args) throws Exception { // main 메소드 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기위한 bufferedreader 선언
		StringBuilder sb = new StringBuilder(); // 출력할 답을 저장할 stringbuilder 선언
		int N = Integer.parseInt(br.readLine()); // 추의 개수 입력
		int[] chu = new int[N]; // 추의 무게를 저장할 배열 선언
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 추의 무게들이 한줄에 입력되므로 구분을 위한 stringtokenizer 선언
		boolean[] weight = new boolean[15001]; // 측정이 가능한 무게를 구분하기 위한 boolean 배열 선언, 추의 최대개수 30, 추의 최대무게 500이므로 최대 15000까지 가능
		weight[0] = true; // 0g의 무게는 항상 측정 가능
		for (int i = 0; i < N; i++) { // 추의 개수만큼 반복
			int tmp = Integer.parseInt(st.nextToken()); // 추의 무게 입력
			chu[i] = tmp; // 추의 무게 저장
			for (int j = 15000; j >= 0; j--) { // 측정이 가능한 무게 탐색 후
				if (weight[j] && j + tmp <= 15000) { // 추의 무게를 더했을 때 15000 이하라면
					weight[j + tmp] = true; // 그 무게도 측정 가능하다고 저장
				} // End of if
			} // End of for
		} // End of for
		for (int i = 0; i < N; i++) { // 추의 개수만큼 반복
			int tmp = chu[i]; // i번째 추의 무게에 대하여
			for (int j = 0; j < 15001; j++) { // 측정이 가능한 무게 탐색 후
				if (weight[j] && j - tmp > 0) { // i번째 추의 무게를 뺐을 때 0g 이상이면
					weight[j - tmp] = true; // 뺀 무게도 측정 가능
				} // 추를 측정할 구슬이 있는 저울에 올릴 수도 있기 때문에 체크를 해주어야한다.
			} // End of for
		} // End of for
		N = Integer.parseInt(br.readLine()); // 측정할 구슬의 개수 입력
		st = new StringTokenizer(br.readLine(), " "); // 구슬별 무게 구분
		for (int i = 0; i < N; i++) { // N번 반복
			int tmp = Integer.parseInt(st.nextToken()); // 측정할 구슬의 무게 입력
			if (tmp > 15000 || !weight[tmp]) // 구슬의 무게가 15000이 넘거나 측정이 불가능한 무게일 경우
				sb.append("N"); // N 출력
			else // 구슬의 무게가 15000 이하이고 측정이 가능한 무게일 경우
				sb.append("Y"); // Y 출력
			sb.append(" "); // 구슬마다 공백으로 구분
		} // End of for
		sb.deleteCharAt(sb.length() - 1); // 마지막 공백 삭제
		System.out.print(sb.toString()); // 답 출력
	} // End of main
} // End of class