import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coor = new int[4];
            for(int i = 0; i < 4; i++){
                coor[i] = Integer.parseInt(st.nextToken());
            }
            int N = Integer.parseInt(br.readLine());
            int ans = 0;
            while(N-- > 0) {
                st = new StringTokenizer(br.readLine());
                int[] system = new int[3];
                for(int i = 0; i < 3; i++){
                    system[i] = Integer.parseInt(st.nextToken());
                }
                system[2] *= system[2];
                int[] tmp = new int[4];
                for(int i = 0; i < 4; i++){
                    tmp[i] = coor[i] - system[i%2];
                    tmp[i] *= tmp[i];
                }
                if(tmp[0] + tmp[1] < system[2] ^ tmp[2] + tmp[3] < system[2]){
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
