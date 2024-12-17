import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        int[] time = new int[100001];

        Arrays.fill(time, -1);

        q.add(N);
        time[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur - 1 >= 0 && time[cur - 1] == -1) {
                q.add(cur - 1);
                time[cur - 1] = time[cur] + 1;
            }
            
            if (cur * 2 <= 100000 && time[cur * 2] == -1) {
                q.add(cur * 2);
                time[cur * 2] = time[cur];
            }

            if (cur + 1 <= 100000 && time[cur + 1] == -1) {
                q.add(cur + 1);
                time[cur + 1] = time[cur] + 1;
            }

        }
        System.out.println(time[K]);
    }
}