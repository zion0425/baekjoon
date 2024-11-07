import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->
                o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]
        );


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            q.offer(new int[]{s, e});
        }


        int cnt = 0;
        int end = 0;
        while (n-- > 0) {
            int s = q.peek()[0];
            int e = q.poll()[1];
            if (end > s) continue;
            end = e;
            cnt++;
        }
        System.out.println(cnt);
    }
}

