import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc = new Scanner(System.in);
		int[] dx = {1, 1, 1, 0};
		int[] dy = {1, 0, -1, 1};
		int[][] pan = new int[19][19];
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				pan[i][j] = sc.nextInt();
			}
		}
		
		for(int j = 0; j < 19; j++) {
			for(int i = 0; i < 19; i++) {
				int player = pan[i][j];
				if(player != 0) {
					for(int k = 0; k < 4; k++) {
						int count = 1;
						int x = j;
						int y = i;
						if(!(x-dx[k]<0||x-dx[k]>=19||y-dy[k]<0||y-dy[k]>=19)&&pan[y-dy[k]][x-dx[k]]==player) {
							continue;
						}
						while(count < 6) {
							x += dx[k];
							y += dy[k];
							if(x<0||x>=19||y<0||y>=19||pan[y][x]!=player) {
								break;
							}
							count++;
						}
						if(count == 5) {
							System.out.printf("%d\n%d %d", player, i+1, j+1);
							System.exit(0);
						}
					}
				}
			}
		}
		System.out.println(0);
		sc.close();
	}
}