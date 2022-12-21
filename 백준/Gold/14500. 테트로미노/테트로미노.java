import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[][][] tetromino = {
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {2, 0}, {3, 0}},
            {{1, 0}, {0, 1}, {1, 1}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{1, 0}, {2, 0}, {2, -1}},
            {{1, 0}, {2, 0}, {0, -1}},
            {{1, 0}, {2, 0}, {0, 1}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{0, 1}, {0, 2}, {-1, 2}},
            {{0, 1}, {0, 2}, {-1, 0}},
            {{0, 1}, {0, 2}, {1, 0}},
            {{1, 0}, {1, 1}, {2, 1}},
            {{1, 0}, {1, -1}, {2, -1}},
            {{0, 1}, {1, 1}, {1, 2}},
            {{0, 1}, {-1, 1}, {-1, 2}},
            {{1, 0}, {2, 0}, {1, 1}},
            {{1, 0}, {2, 0}, {1, -1}},
            {{0, 1}, {0, 2}, {1, 1}},
            {{0, 1}, {0, 2}, {-1, 1}},
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] table = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a:
                for (int k = 0; k < 19; k++) {
                    int sum = table[i][j];
                    for (int l = 0; l < 3; l++) {
                        int nextR = i + tetromino[k][l][0];
                        int nextC = j + tetromino[k][l][1];
                        if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue a;
                        sum += table[nextR][nextC];
                    }
                    if (sum > ans) ans = sum;
                }
            }
        }
        System.out.println(ans);
    }
}