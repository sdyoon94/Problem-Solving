import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] sudoku = new int[9][9];
		ArrayList<Pos> zero = new ArrayList<>();
		boolean[][] row = new boolean[9][10];
		boolean[][] col = new boolean[9][10];
		boolean[][] sqr = new boolean[9][10];
		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				if ((sudoku[i][j] = input.charAt(j) - '0') == 0) {
					zero.add(new Pos(i, j));
					continue;
				}
				row[i][sudoku[i][j]] = true;
				col[j][sudoku[i][j]] = true;
				sqr[(i / 3) * 3 + j / 3][sudoku[i][j]] = true;
			}
		}
		if (sudoking(zero, sudoku, row, col, sqr, 0)) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					sb.append(sudoku[i][j]);
				sb.append("\n");
			}
			System.out.print(sb.toString());
		} else {
			System.out.print(-1);
		}
		return;
	}

	private static boolean sudoking(ArrayList<Pos> zero, int[][] sudoku, boolean[][] row, boolean[][] col, boolean[][] sqr, int idx) {
		if (idx == zero.size())
			return true;
		Pos cur = zero.get(idx);
		for (int i = 1; i < 10; i++) {
			if (row[cur.r][i] || col[cur.c][i] || sqr[cur.sqrNum][i])
				continue;
			row[cur.r][i] = true;
			col[cur.c][i] = true;
			sqr[cur.sqrNum][i] = true;
			sudoku[cur.r][cur.c] = i;
			if (sudoking(zero, sudoku, row, col, sqr, idx + 1))
				return true;
			row[cur.r][i] = false;
			col[cur.c][i] = false;
			sqr[cur.sqrNum][i] = false;
		}
		return false;
	}

	static class Pos {
		int r, c, sqrNum;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
			sqrNum = (r / 3) * 3 + c / 3;
		}
	}
}