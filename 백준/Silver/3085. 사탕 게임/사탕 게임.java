import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    private static int N, max = 1;
    private static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        check();
        char tmp;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] != board[i][j + 1]) {
                    tmp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = tmp;
                    check();
                    board[i][j + 1] = board[i][j];
                    board[i][j] = tmp;
                }
                if (board[j][i] != board[j + 1][i]) {
                    tmp = board[j][i];
                    board[j][i] = board[j + 1][i];
                    board[j + 1][i] = tmp;
                    check();
                    board[j + 1][i] = board[j][i];
                    board[j][i] = tmp;
                }
            }
        }
        System.out.print(max);
    }

    public static void check() {
        int count1 = 1, count2 = 1;
        for (int i = 0; i < N; i++) {
            count1 = count2 = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count1++;
                    if (count1 > max) {
                        max = count1;
                    }
                } else {
                    count1 = 1;
                }
                if (board[j][i] == board[j + 1][i]) {
                    count2++;
                    if (count2 > max) {
                        max = count2;
                    }
                } else {
                    count2 = 1;
                }
            }
        }
    }
}