import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static int N, size;
    private static ArrayList<Integer> length;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        length = new ArrayList<>();
        length.add(0);
        while (length.get(size = length.size() - 1) < N) {
            length.add(length.get(size) * 2 + size + 3);
        }
        System.out.println(solution(N));
    }

    public static char solution(int N) {
        int left = 0, right = size;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (length.get(mid) == N) {
                return 'o';
            } else if (length.get(mid) < N) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        N -= length.get(left);
        if (N <= left + 3) {
            return N == 1 ? 'm' : 'o';
        } else {
            size = left;
            return solution(N - left - 3);
        }
    }
}