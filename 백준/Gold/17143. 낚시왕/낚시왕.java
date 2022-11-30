import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Shark[] sharks;
	static int R, C, M, ans;
	static int[][] map, next_map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		next_map = new int[R][C];
		sharks = new Shark[M + 1];
		ans = 0;
		for (int i = 1; i <= M; i++) {
			sharks[i] = new Shark(br.readLine());
			if (next_map[sharks[i].r][sharks[i].c] != 0) {
				eat(next_map[sharks[i].r][sharks[i].c], i);
			} else {
				next_map[sharks[i].r][sharks[i].c] = i;
			}
		}

		for (int i = 0; i < C; i++) {
			map = next_map;
			next_map = new int[R][C];
			fishing(i);
			sharkMove();
		}

		System.out.println(ans);
	}

	private static void fishing(int c) {
		for (int i = 0; i < R; i++) {
			if (map[i][c] != 0) {
				ans += sharks[map[i][c]].z;
				sharks[map[i][c]] = null;
				map[i][c] = 0;
				return;
			}
		}
	}

	private static void sharkMove() {
		for (int i = 1; i <= M; i++) {
			if (sharks[i] == null) {
				continue;
			}
			int moving = sharks[i].s;
			int nextR = sharks[i].r, nextC = sharks[i].c;
			if (sharks[i].d < 3) {
				moving %= 2 * (R - 1);
				if (sharks[i].d == 1) {
					nextR -= moving;
				} else {
					nextR += moving;
				}
				while (nextR < 0 || nextR >= R) {
					if (nextR < 0) {
						sharks[i].d = 2;
						nextR = -nextR;
					} else {
						sharks[i].d = 1;
						nextR = 2 * (R - 1) - nextR;
					}
				}
			} else {
				moving %= 2 * (C - 1);
				if (sharks[i].d == 4) {
					nextC -= moving;
				} else {
					nextC += moving;
				}
				while (nextC < 0 || nextC >= C) {
					if (nextC < 0) {
						sharks[i].d = 3;
						nextC = -nextC;
					} else {
						sharks[i].d = 4;
						nextC = 2 * (C - 1) - nextC;
					}
				}
			}
			sharks[i].r = nextR;
			sharks[i].c = nextC;
			if (next_map[nextR][nextC] != 0) {
				eat(i, next_map[nextR][nextC]);
			} else {
				next_map[nextR][nextC] = i;
			}
		}
	}

	static class Shark {
		int r, c, s, d, z;

		Shark(String str) {
			StringTokenizer st = new StringTokenizer(str);
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
		}
	}

	static void eat(int a, int b) {
		if (sharks[a].z > sharks[b].z) {
			sharks[b] = null;
			next_map[sharks[a].r][sharks[a].c] = a;
		} else {
			sharks[a] = null;
			next_map[sharks[b].r][sharks[b].c] = b;
		}
	}
}