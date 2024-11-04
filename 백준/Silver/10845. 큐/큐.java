import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    q.push(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    sb.append(q.isEmpty() ? "-1" : q.getLast()).append('\n');
                    break;
                case "back":
                    sb.append(q.isEmpty() ? "-1" : q.peek()).append('\n');
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? "-1" : q.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? '1' : '0').append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}
