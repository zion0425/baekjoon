import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int[][] map;
    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while (true) {
            int cnt = countIcebergs();

            if (cnt >= 2) {
                System.out.println(year);
                return;
            }
            if (cnt == 0) {
                System.out.println(0);
                return;
            }

            melt();
            year++;
        }
    }

    static int countIcebergs() {
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + delta[d][0];
            int ny = y + delta[d][1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && map[nx][ny] > 0 && !visited[nx][ny]) {
                dfs(nx, ny, visited);
            }
        }
    }

    static void melt() {
        int[][] newMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    int seaCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + delta[d][0];
                        int ny = j + delta[d][1];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m
                                && map[nx][ny] == 0) {
                            seaCount++;
                        }
                    }

                    newMap[i][j] = Math.max(0, map[i][j] - seaCount);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.copyOf(newMap[i], m);
        }
    }
}