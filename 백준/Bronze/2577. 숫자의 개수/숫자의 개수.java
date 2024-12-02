import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mul = 1;
        for (int i = 0; i < 3; i++) {
            mul *= Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        String m = String.valueOf(mul);
        for (char i = '0'; i <= '9'; i++) {
            char finalI = i;
            sb.append(m.chars()
                    .filter(c -> c == finalI)
                    .count())
                .append('\n');
        }
        System.out.print(sb);
    }
}