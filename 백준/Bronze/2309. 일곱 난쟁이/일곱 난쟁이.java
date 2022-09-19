import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = -100;
        int[] heights = new int[9];
        // 입력
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }
        // 오름차순 정렬
        Arrays.sort(heights);
        // 풀이
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] + heights[j] == sum) {
                    for (int k = 0; k < 9; k++) {
                        if (i == k || j == k) {
                            continue;
                        }
                        System.out.println(heights[k]);
                    }
                    return;
                }
            }
        }
    }
}