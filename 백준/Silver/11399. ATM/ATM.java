import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = n;
        while (i-- > 0) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        int[] sum = new int[n + 1];
        sum[0] = (q.isEmpty()) ? 0 : q.poll();
        i = 0;
        while (++i < n) {
            sum[i] = sum[i - 1] + q.poll();
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            ans += sum[j];
        }

        System.out.println(ans);


    }
}

