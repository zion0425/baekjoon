import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(pq.isEmpty() ? "0" : pq.poll()).append('\n');
                continue;
            }
            pq.offer(num);
        }
        System.out.print(sb);
    }
}
