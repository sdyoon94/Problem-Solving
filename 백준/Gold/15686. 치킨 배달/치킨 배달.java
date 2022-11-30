import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static int houseNum, chickenNum, N, M;
	static ArrayList<int[]> house = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				switch (input.charAt(j * 2)) {
				case '1':
					house.add(new int[] { i, j });
					break;
				case '2':
					chicken.add(new int[] { i, j });
				}
			}
		}
		houseNum = house.size();
		chickenNum = chicken.size();
		int[] d = new int[houseNum];
		Arrays.fill(d, Integer.MAX_VALUE);
		Process(d, 0, 0);
		System.out.println(ans);
	}

	private static void Process(int[] d, int index, int num) {
		if (chickenNum - index < M - num)
			return;
		if (num == M) {
			int cur = 0;
			for (int i : d)
				cur += i;
			if (ans > cur)
				ans = cur;
			return;
		}
		int[] new_d;
		for (int i = index; i < chickenNum; i++) {
			new_d = d.clone();
			calculate(new_d, i);
			Process(new_d, i + 1, num + 1);
			new_d = d.clone();
			Process(new_d, i + 1, num);
		}
	}

	private static void calculate(int[] d, int index) {
		int[] cur = chicken.get(index);
		for (int i = 0; i < houseNum; i++) {
			int[] cur2 = house.get(i);
			int dis = Math.abs(cur[0] - cur2[0]) + Math.abs(cur[1] - cur2[1]);
			if (d[i] > dis)
				d[i] = dis;
		}
	}
}