import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < M; i++){
            String input = br.readLine();
            if(set.contains(input)){
                ans.add(input);
            }
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        for(String i : ans){
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}
