import java.util.*;
import java.io.*;
public class Main {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(st.nextToken());
        int[][] delta = {{1, 0},{-1,0},{0,1},{0,-1}};

        ArrayDeque<int[]> q = new ArrayDeque<>();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];
            boolean[][] visit = new boolean[n][m];
            int res = 0;

            for (int i =0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int i =0 ; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0 || visit[i][j]) continue;
                    res++;
                    q.offer(new int[]{i,j});
                    visit[i][j] = true;

                    while (!q.isEmpty()) {
                        int dx = q.peek()[0];
                        int dy = q.poll()[1];

                        for (int d = 0; d < delta.length; d++) {
                            int rx = dx + delta[d][0];
                            int ry = dy + delta[d][1];

                            if (ry < m && ry >= 0 && rx >= 0 && rx < n && map[rx][ry] != 0 && !visit[rx][ry]) {
                                visit[rx][ry] = true;
                                q.offer(new int[] {rx, ry});
                            }
                        }
                    }
                }

            }
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}