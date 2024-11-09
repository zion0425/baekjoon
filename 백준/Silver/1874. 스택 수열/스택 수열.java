import java.util.*;
import java.io.*;
public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());

        int now = 1;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(br.readLine());
            while (now <= num) {
                sb.append('+').append('\n');
                s.push(now++);
            }
            if (s.peek() != num) {
                System.out.println("NO");
                return;
            }
            s.pop();
            sb.append('-').append('\n');
        }
        System.out.print(sb);

    }
}