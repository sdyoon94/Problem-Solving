import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ans = 0;
        int R = H/2;
        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if((X <= x && x <= X + W && Y <= y && y <= Y + H)||(X - x)*(X - x) + (Y - y + R)*(Y - y + R) <= R*R ||(X - x + W)*(X - x + W) + (Y - y + R)*(Y - y + R) <= R*R){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
