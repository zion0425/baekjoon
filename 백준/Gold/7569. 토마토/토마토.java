import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static int[][][] tomato;
    private static ArrayList<int[]> goodTomato;

    static int totalCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        goodTomato = new ArrayList<>();
        tomato = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        goodTomato.add(new int[]{i, j, k});
                    } else if (tomato[i][j][k] == 0) {
                        totalCnt++;
                    }
                }
            }
        }


       max = Math.max(max, dfs());

        System.out.println(totalCnt == 0 ? max : -1);

    }

    static int max = 0;
    private static int m;
    private static int n;
    private static int h;

    static int dfs() {
        int cnt = -1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.addAll(goodTomato);
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cz = queue.peek()[0];
                int cy = queue.peek()[1];
                int cx = queue.poll()[2];

                for (int d = 0; d < 6; d++) {
                    int mz = cz + dz[d];
                    int my = cy + dy[d];
                    int mx = cx + dx[d];

                    if (isIn(mz, my, mx) && tomato[mz][my][mx] == 0) {
                        totalCnt--;
                        queue.offer(new int[]{mz, my, mx});
                        tomato[mz][my][mx] = 1;
                    }
                }
            }
        }
        return cnt;
    }

    static boolean isIn(int z, int y, int x) {
        return (z >= 0 && y >= 0 && x >= 0 && z < h && y < n && x < m);
    }
}
