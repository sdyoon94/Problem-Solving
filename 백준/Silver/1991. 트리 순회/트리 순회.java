import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] alpha = new Node[26];
		while (N-- > 0) {
			String input = br.readLine();
			alpha[input.charAt(0) - 'A'] = new Node(input.charAt(2) == '.' ? -1 : input.charAt(2) - 'A',
					input.charAt(4) == '.' ? -1 : input.charAt(4) - 'A');
		}
		StringBuilder sb = new StringBuilder();
		preorder(alpha, sb, 0);
		sb.append("\n");
		inorder(alpha, sb, 0);
		sb.append("\n");
		postorder(alpha, sb, 0);
		System.out.print(sb.toString());
	}
	
	static void preorder(Node[] alpha, StringBuilder sb, int cur) {
		sb.append((char)(cur + 'A'));
		if(alpha[cur].left != -1) preorder(alpha, sb, alpha[cur].left);
		if(alpha[cur].right != -1) preorder(alpha, sb, alpha[cur].right);
	}
	static void inorder(Node[] alpha, StringBuilder sb, int cur) {
		if(alpha[cur].left != -1) inorder(alpha, sb, alpha[cur].left);
		sb.append((char)(cur + 'A'));
		if(alpha[cur].right != -1) inorder(alpha, sb, alpha[cur].right);
	}
	static void postorder(Node[] alpha, StringBuilder sb, int cur) {
		if(alpha[cur].left != -1) postorder(alpha, sb, alpha[cur].left);
		if(alpha[cur].right != -1) postorder(alpha, sb, alpha[cur].right);
		sb.append((char)(cur + 'A'));
	}

	static class Node {
		int left, right;

		public Node(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}
	}
}