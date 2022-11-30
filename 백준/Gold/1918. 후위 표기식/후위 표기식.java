import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0, size = input.length(); i < size; i++) {
			switch (input.charAt(i)) {
			case '+':
			case '-':
				while (!stack.isEmpty() && stack.peek() != '(')
					sb.append(stack.pop());
			case '*':
			case '/':
				while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'))
					sb.append(stack.pop());
			case '(':
				stack.push(input.charAt(i));
				break;
			case ')':
				while (stack.peek() != '(')
					sb.append(stack.pop());
				stack.pop();
				break;
			default:
				sb.append(input.charAt(i));
			}
		}
		while (!stack.isEmpty())
			sb.append(stack.pop());
		System.out.print(sb.toString());
	}
}