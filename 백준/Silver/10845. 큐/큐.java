import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] queue = new int[N];
        int front = 0, back = 0, size = 0;
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            switch (st.nextToken()) {
                case "push":
                    queue[back++] = Integer.parseInt(st.nextToken());
                    size++;
                    break;
                case "pop":
                    if (size == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue[front++]).append("\n");
                        size--;
                    }
                    break;
                case "size":
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    if (size == 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (size == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue[front]).append("\n");
                    }
                    break;
                case "back":
                    if (size == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue[back - 1]).append("\n");

                    }
            }
        }
        System.out.print(sb);
    }
}