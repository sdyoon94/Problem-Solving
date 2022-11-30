import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int[] ans = new int[total];
		int max=0;
		for(int c=0;c<total;c++){
			ans[c] = Integer.parseInt(br.readLine());
			if(max<ans[c]){
				max = ans[c];
			}
		}
		int[] arr = new int[max+1];
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;
		for(int i=4;i<=max;i++){
			arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
		}
		for(int c=0;c<total;c++){
			System.out.println(arr[ans[c]]);
		}
	}

}