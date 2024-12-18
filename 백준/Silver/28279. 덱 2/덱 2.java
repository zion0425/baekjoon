
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int com = Integer.parseInt(st.nextToken());
            switch (com) {
                case 1 :
                    int num1 = Integer.parseInt(st.nextToken());
                    q.addFirst(num1);
                    break;
                case 2 :
                    int num2 = Integer.parseInt(st.nextToken());
                    q.addLast(num2);
                    break;
                case 3:
                    sb.append(!q.isEmpty() ? q.pollFirst() : "-1").append('\n');
                    break;
                case 4:
                    sb.append(!q.isEmpty() ? q.pollLast() : "-1").append('\n');
                    break;
                case 5:
                    sb.append(q.size()).append('\n');
                    break;
                case 6:
                    sb.append(q.isEmpty() ? '1' : '0').append('\n');
                    break;
                case 7:
                    sb.append(q.isEmpty() ? "-1" : q.peekFirst()).append('\n');
                    break;
                case 8:
                    sb.append(q.isEmpty() ? "-1" : q.peekLast()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }
}
