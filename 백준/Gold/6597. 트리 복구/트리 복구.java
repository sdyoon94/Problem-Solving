import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuffer ans = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input, " ");
            postOrder(st.nextToken(), st.nextToken());
            ans.append("\n");
        }
        System.out.println(ans.toString());
    }

    public static void postOrder(String preOrder, String inOrder) {
        int size = preOrder.length();
        if (size == 0) {
            return;
        }
        char root = preOrder.charAt(0);
        int idx = inOrder.indexOf(root);
        postOrder(preOrder.substring(1, idx + 1), inOrder.substring(0, idx));
        postOrder(preOrder.substring(idx + 1), inOrder.substring(idx + 1));
        ans.append(root);
    }
}