import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] edgeCount = new int[N + 1];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0; i <= N; i++) arr.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            edgeCount[b]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i<=N;i++){
            if (edgeCount[i] == 0) {
                q.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int n = q.poll();
            sb.append(n).append(" ");
            for(int i : arr.get(n)){
                edgeCount[i]--;
                if(edgeCount[i]==0){
                    q.offer(i);
                }
            }
        }
        System.out.println(sb.toString());
    }
}