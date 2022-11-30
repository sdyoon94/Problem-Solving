import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 1번 문제 시작
	static int[] number = { 9, 4, 8, 7, 2, 1, 6, 5, 0, 3 }; // 숫자별 알파벳 순서 저장

	public static void main(String[] args) throws Exception { // main 메소드 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 bufferedreader 선언
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 한 줄에 여러개의 입력이 있으므로 StringTokenizer 선언
		StringBuilder sb = new StringBuilder(); // 출력할 답안을 저장하기 위한 stringbuilder 선언
		int M = Integer.parseInt(st.nextToken()); // M 입력
		int N = Integer.parseInt(st.nextToken()); // N 입력
		order[] arr = new order[N - M + 1]; // M 이상 N 이하의 정수를 저장할 배열 선언;
		for (int i = M; i <= N; i++) { // M부터 N까지
			arr[i - M] = new order(i); // 정수 저장
		} // End of for
		Arrays.sort(arr); // 지정한 규칙에 따라 sort
		int count = 0; // 10번째 마다 개행을 하기 위한 count 선언
		for (order i : arr) { // 순서대로 출력해주기 위한 foreach
			if (count++ == 10) { // count가 10이면
				sb.deleteCharAt(sb.length() - 1); // sb의 마지막 문자(' ')를 제거하고
				sb.append("\n"); // 개행
				count = 1; // count 초기화
			} // End of if
			sb.append(i.num).append(" "); // 순서에 맞는 숫자 저장
		} // End of for
		System.out.print(sb.toString()); // 답안 출력
	} // End of main

	static class order implements Comparable<order> { // 정렬 규칙을 정하기 위한 order 클래스 선언
		String num; // 숫자를 string 타입으로 저장

		public order(int num) { // 생성자
			this.num = Integer.toString(num); // 숫자를 입력받으면 string으로 변환해서 저장
		} // End of constructor

		@Override
		public int compareTo(order o) { // 정렬 규칙
			if (num.charAt(0) == o.num.charAt(0)) { // 만약 첫번째 숫자가 같을 경우에
				if (num.length() == 1) 	// 한 자리 숫자가
					return -1;			// 있을 경우
				if (o.num.length() == 1)// 그 숫자가
					return 1;			// 앞으로 가도록 정렬
				return number[num.charAt(1) - '0'] - number[o.num.charAt(1) - '0']; // 둘 다 두자리 숫자일 경우 두번째 숫자를 비교
			} // End of if
			return number[num.charAt(0) - '0'] - number[o.num.charAt(0) - '0']; // 첫번째 숫자가 다르다면 첫번째 숫자를 비교
		} // End of method
	} // End of class
} // End of class