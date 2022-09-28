import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Log[] logs = new Log[N+1];
        for(int i = 1; i <= N; i++){
            logs[i] = new Log();
            logs[i].log.add(i);
        }
        logs[1].value = 0;
        for(int i = 2; i <= N; i++){
            int min = i;
            int cur;
            if(i%3==0){
                cur = i/3;
                if(logs[min].value > logs[cur].value){
                    min = cur;
                }
            }
            if(i%2==0){
                cur = i/2;
                if(logs[min].value > logs[cur].value){
                    min = cur;
                }
            }
            cur = i - 1;
            if(logs[min].value > logs[cur].value){
                min = cur;
            }
            logs[i].value = logs[min].value + 1;
            logs[i].log.addAll(logs[min].log);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(logs[N].value).append("\n");
        for(int i : logs[N].log){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static class Log{
        int value = Integer.MAX_VALUE;
        ArrayList<Integer> log = new ArrayList<Integer>();
    }
}
