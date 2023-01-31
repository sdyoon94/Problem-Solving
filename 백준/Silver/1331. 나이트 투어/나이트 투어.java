import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visited = new boolean[6][6];
        String input = br.readLine();
        int prevR = input.charAt(0) - 'A';
        int prevC = input.charAt(1) - '1';
        visited[prevR][prevC] = true;
        int firstR = prevR;
        int firstC = prevC;
        int curR, curC, difR, difC;
        for (int i = 1; i < 36; i++) {
            input = br.readLine();
            curR = input.charAt(0) - 'A';
            curC = input.charAt(1) - '1';
            difR = Math.abs(curR - prevR);
            difC = Math.abs(curC - prevC);
            if (visited[curR][curC] || difR + difC != 3 || (difR != 1 && difR != 2)) {
                System.out.println("Invalid");
                return;
            }
            visited[curR][curC] = true;
            prevR = curR;
            prevC = curC;
        }
        difR = Math.abs(firstR - prevR);
        difC = Math.abs(firstC - prevC);
        if (difR + difC != 3 || (difR != 1 && difR != 2)) {
            System.out.println("Invalid");
        } else {
            System.out.println("Valid");
        }
    }
}