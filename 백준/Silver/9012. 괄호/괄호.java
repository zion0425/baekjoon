
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            Stack<Character> s = new Stack<>();
            String str = br.readLine();
            int i = 0;
            for (; i <str.length(); i++) {
                if (str.charAt(i) == '(') {
                    s.push(str.charAt(i));
                } else {
                    if (s.isEmpty() || s.pop() != '(') break;
                }
            }
            sb.append(s.isEmpty() && i == str.length() ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }
}
