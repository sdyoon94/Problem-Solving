import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = 1 << Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		System.out.println(process(0, N, 0, N, r, c));
	}

	private static int process(int iStart, int iEnd, int jStart, int jEnd, int r, int c) {
		int len = iEnd - iStart;
		if(iStart > r) return 0;
		if(iEnd <= r) return len * len;
		if(jStart > c) return 0;
		if(jEnd <= c) return len * len;
		if(len == 1) return 0;
		int iMid = (iStart + iEnd) / 2;
		int jMid = (jStart + jEnd) / 2;
		return 	process(iStart, iMid, jStart, jMid, r, c) + 
				process(iMid, iEnd, jStart, jMid, r, c) +
				process(iStart, iMid, jMid, jEnd, r, c) +
				process(iMid, iEnd, jMid, jEnd, r, c);
	}
}