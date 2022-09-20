import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] dice = new int[3];
        for (int i = 0; i < dice.length; i++) dice[i] = Integer.parseInt(st.nextToken());
        if (dice[0] == dice[1] && dice[1] == dice[2]) {
            System.out.println(10000 + dice[0] * 1000);
        } else if (dice[0] == dice[1]) {
            System.out.println(1000 + dice[0] * 100);
        } else if (dice[0] == dice[2]) {
            System.out.println(1000 + dice[0] * 100);
        } else if (dice[1] == dice[2]) {
            System.out.println(1000 + dice[1] * 100);
        } else {
            System.out.println(Math.max(Math.max(dice[0], dice[1]), dice[2]) * 100);
        }

    }
}
