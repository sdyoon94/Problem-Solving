import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] memory = new int[32];
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            memory[0] = cal(input);
            int pc = 0;
            int adder = 0;
            for (int i = 1; i < 32; i++) {
                memory[i] = cal(br.readLine());
            }
            int command;
            while ((command = memory[pc] >> 5) != 7) {
                int operand = memory[pc] & 31;
                pc = (pc + 1) & 31;
                switch (command) {
                    case 0:
                        memory[operand] = adder;
                        break;
                    case 1:
                        adder = memory[operand];
                        break;
                    case 2:
                        if (adder == 0) {
                            pc = operand;
                        }
                        break;
                    case 4:
                        adder = (adder - 1) & 255;
                        break;
                    case 5:
                        adder = (adder + 1) & 255;
                        break;
                    case 6:
                        pc = operand;
                        break;
                }
            }
            sb.append(String.format("%8s\n", Integer.toBinaryString(adder)).replace(' ', '0'));
        }
        System.out.println(sb);
    }

    public static int cal(String input) {
        int size = input.length();
        int result = 0;
        for (int i = 0; i < size; i++) {
            result <<= 1;
            result += input.charAt(i) - '0';
        }
        return result;
    }
}