import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    if (set.contains(Integer.parseInt(st.nextToken()))) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    int cur = Integer.parseInt(st.nextToken());
                    if (set.contains(cur)) {
                        set.remove(cur);
                    } else {
                        set.add(cur);
                    }
                    break;
                case "all":
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.print(sb);
    }
}
