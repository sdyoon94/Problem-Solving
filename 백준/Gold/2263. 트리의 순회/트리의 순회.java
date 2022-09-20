import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int n, idx = 0;
    private static int[] inorder, postorder, preorder;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        preorder = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st1.nextToken());
            postorder[i] = Integer.parseInt(st2.nextToken());
        }
        dc(0, n-1, 0, n-1);
        StringBuilder sb = new StringBuilder();
        for(int i:preorder) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    public static void dc(int is, int ie, int ps, int pe){
        if(is <= ie && ps <= pe){
            preorder[idx++] = postorder[pe];
            int pos = position(postorder[pe]);
            dc(is, pos - 1, ps, ps + pos - is - 1);
            dc(pos + 1, ie, ps + pos - is, pe - 1);
        }
    }

    public static int position(int num){
        for(int i = 0; i < n; i++){
            if(inorder[i] == num) return i;
        }
        return 0;
    }

    static class Node{
        int value;
        Node left, right, parent;
    }
}
