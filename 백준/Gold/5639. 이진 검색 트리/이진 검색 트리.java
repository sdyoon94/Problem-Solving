import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> preorder = new ArrayList<>();
		String input;
		while ((input = br.readLine()) != null && !input.equals(""))
			preorder.add(Integer.parseInt(input));
		postorder(preorder, sb, 0, preorder.size());
		System.out.println(sb.toString());
	}

	private static void postorder(ArrayList<Integer> preorder, StringBuilder sb, int s, int e) {
		if (s >= e)
			return;
		int root = preorder.get(s);
		int sep = binarySearch(preorder, root, s + 1, e);
		postorder(preorder, sb, s + 1, sep);
		postorder(preorder, sb, sep, e);
		sb.append(preorder.get(s)).append("\n");
	}

	private static int binarySearch(ArrayList<Integer> preorder, int root, int s, int e) {
		if (s >= e)
			return s;
		int m = (s + e) / 2;
		if (preorder.get(m) > root)
			return binarySearch(preorder, root, s, m);
		else
			return binarySearch(preorder, root, m + 1, e);
	}
}