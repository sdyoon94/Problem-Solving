import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		ArrayDeque<Character> ad = new ArrayDeque<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0, size = input.length(); i < size; i++) {
			switch(input.charAt(i)) {
			case '<':
				while(!ad.isEmpty()) sb.append(ad.pollLast());
				sb.append('<');
				while(input.charAt(++i) != '>') sb.append(input.charAt(i));
				sb.append('>');
				break;
			case ' ':
				while(!ad.isEmpty()) sb.append(ad.pollLast());
				sb.append(' ');
				break;
			default:
				ad.offerLast(input.charAt(i));
			}
		}
		while(!ad.isEmpty()) sb.append(ad.pollLast());
		System.out.println(sb.toString());
	}
}