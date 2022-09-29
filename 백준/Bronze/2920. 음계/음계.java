import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = "1 2 3 4 5 6 7 8";
        String B = "8 7 6 5 4 3 2 1";
        String input = br.readLine();
        if(A.equals(input)){
            System.out.println("ascending");
        }else if(B.equals(input)){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }
}