import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        PriorityQueue <int[] > q = new PriorityQueue<>((o1, o2) ->
                (o1[1] != o2[1]) ? o1[1] - o2[1] : o1[0] - o2[0]
        );

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            q.offer(new int[] {x, y});
        }

        for (int i = 0; i < n; i++) {
            sb.append(q.peek()[0]).append(' ').append(q.poll()[1]).append('\n');
        }
        System.out.println(sb);
    }
}