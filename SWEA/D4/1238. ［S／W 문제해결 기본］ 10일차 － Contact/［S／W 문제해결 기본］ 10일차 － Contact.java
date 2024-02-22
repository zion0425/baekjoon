import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Edge {
        int from;
        int to;

        public Edge (int from, int to) {
            this.from = from;
            this.to = to;
        }

    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            edgeList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n / 2; i++) {
                edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            visit = new boolean[101];
            sb.append("#").append(t).append(" ").append(bfs(start)).append("\n");
        }
        System.out.println(sb);
    }
    static ArrayList<Edge>edgeList;
    static boolean[] visit;
    public static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visit[start] = true;
        int max = 0;
        while (!queue.isEmpty()){
            // 하나의 level 마다 그 크기만큼 for문 실행
            int size = queue.size();
            max = 0;
            for (int i = 0; i < size; i++) {
                int curFrom = queue.poll();
                // 현재 level에서 가장 큰 값
                max = Math.max(curFrom, max);

                for (Edge e : edgeList) {
                    if (e.from == curFrom && !visit[e.to]) {
                        queue.offer(e.to);
                        visit[e.to] = true;
                    }
                }
            }
        }
        return max;
    }
}
