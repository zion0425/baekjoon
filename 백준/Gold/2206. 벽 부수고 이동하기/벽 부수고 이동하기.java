import java.util.*;
import java.io.*;
public class Main {
    static char[][] map;
    static int n;
    static int m;
    static boolean[][][] visit;
    static Queue<int[]> q = new ArrayDeque<>();

    static int[][] delta = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m =  Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visit = new boolean[2][n][m];

        q.offer(new int[]{0,0,0,0});
        visit[0][0][0] = true;

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int min = -1;
        while (!q.isEmpty()) {
            int y = q.peek()[0];
            int x = q.peek()[1];
            int b = q.peek()[2];
            int mi = q.poll()[3];

            if (y == n - 1 && x == m - 1) {
                min = (min == -1) ? mi + 1 : Math.min(min, mi + 1);
                continue;
            }

            for (int[] ints : delta) {
                int dy = y + ints[0];
                int dx = x + ints[1];

                if (dy >= 0 && dy < n && dx >= 0 && dx < m) {
                    if (b == 0 && map[dy][dx] == '1' && !visit[1][dy][dx]) {
                        visit[1][dy][dx] = true;
                        q.offer(new int[]{dy, dx, 1, mi + 1});
                    } else if (b == 0 && map[dy][dx] == '0' && !visit[0][dy][dx]) {
                        visit[0][dy][dx] = true;
                        q.offer(new int[]{dy, dx, 0, mi + 1});
                    } else if (b == 1 && map[dy][dx] == '0' && !visit[1][dy][dx]) {
                        visit[1][dy][dx] = true;
                        q.offer(new int[]{dy, dx, 1, mi + 1});
                    }
                }
            }
        }
        System.out.println(min);
    }

}

