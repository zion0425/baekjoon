import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push" :
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;
                case "top" :
                    if (stack.isEmpty()) sb.append("-1");
                    else sb.append(stack.peek());
                    sb.append('\n');
                    break;
                case "size" :
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty" :
                    if (stack.isEmpty()) sb.append('1');
                    else sb.append('0');
                    sb.append('\n');
                    break;
                case "pop" :
                    if (stack.isEmpty()) sb.append("-1");
                    else sb.append(stack.pop());
                    sb.append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}
