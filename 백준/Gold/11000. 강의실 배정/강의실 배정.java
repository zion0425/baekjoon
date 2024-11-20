import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> q1 = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> q2 = new PriorityQueue<>();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            q1.offer(new int[]{l, r});
        }

        while (!q1.isEmpty()) {
            int[] cQ1 = q1.poll();
            int l = cQ1[0];
            int r = cQ1[1];

            if (!q2.isEmpty() && q2.peek() <= l) {
                q2.poll();
            }
            q2.offer(r);
        }

        System.out.println(q2.size());
    }
}
