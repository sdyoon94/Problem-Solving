import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int min = 100, max = 0;
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > max) {
                    max = map[i][j];
                }
                if(map[i][j] < min) {
                    min =map[i][j];
                }
            }
        }
        int answer = 1;
        for(int height = min; height < max; height++){
            init();
            int cnt=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && map[i][j] > height){
                        dfs(i,j,height);
                        cnt++;
                    }

                }
            }
            if(answer < cnt){
                answer = cnt;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int r, int c, int height) {
        visited[r][c] = true;
        for(int i=0; i<4; i++) {
            int nr = r +dr[i];
            int nc = c +dc[i];

            if(nr<0 || nc<0 || nr == N || nc == N) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc]> height) {
                dfs(nr,nc, height);
            }
        }
    }

    public static void init(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                visited[i][j] = false;
            }
        }
    }
}
