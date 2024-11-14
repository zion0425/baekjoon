import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[][] delta = {{-1, 0}, {1, 0}, { 0, -1}, {0, 1}, {-1, -1}, {-1,1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && dfs(i, j)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean dfs(int x, int y) {
        visit[x][y] = true;
        boolean isTop = true;

        for (int d = 0; d < 8; d++) {
            int nx = x + delta[d][0];
            int ny = y + delta[d][1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] > map[x][y]) {
                    isTop = false;
                }
                if (!visit[nx][ny] && map[nx][ny] == map[x][y]) {
                    isTop &= dfs(nx, ny);
                }
            }
        }

        return isTop;
    }
}
