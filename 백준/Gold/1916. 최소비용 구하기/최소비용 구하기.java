import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Bus {
        int vertex, weight;
        Bus next;

        public Bus(int vertex, int weight, Bus next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Bus[] busList = new Bus[N + 1];
        int[] minEdge = new int[N + 1];
        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            busList[from] = new Bus(to, weight, busList[from]);
        }

        Arrays.fill(minEdge, Integer.MAX_VALUE);

        boolean[] visit = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        minEdge[Integer.parseInt(st.nextToken())] = 0;
        int endPoint = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int curVertex = -1;

            for (int j = 1; j <= N; j++) {
                if (!visit[j] && minEdge[j] < min) {
                    min = minEdge[j];
                    curVertex = j;
                }
            }
            if (curVertex == -1 ) break;
            visit[curVertex] = true;
            for (Bus tmp = busList[curVertex]; tmp != null; tmp = tmp.next) {
                if (!visit[tmp.vertex] && minEdge[tmp.vertex] > min + tmp.weight) {
                    minEdge[tmp.vertex] = min + tmp.weight;
                }
            }

         }
        System.out.println(minEdge[endPoint]);
    }
}
