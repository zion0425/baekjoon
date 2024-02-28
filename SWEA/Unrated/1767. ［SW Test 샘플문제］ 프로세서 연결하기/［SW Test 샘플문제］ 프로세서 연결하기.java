import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static class Core {
        int y, x;

        public Core(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N;
    static int[][] maps;
    static ArrayList<Core> coreList;
    static StringBuilder sb = new StringBuilder();
    static int min;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            maps = new int[N][N];
            coreList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                    if (maps[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1) {
                        coreList.add(new Core(i, j));
                    }
                }
            }

            boolean[][] visit = new boolean[N][N];
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            dfs(0, visit, 0, 0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    static boolean[][] clone(boolean[][] v) {
        boolean[][] c = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c[i][j] = v[i][j];
            }
        }
        return c;
    }

    static void dfs(int depth, boolean[][] visit, int sum, int cnt) {
        if (depth == coreList.size()) {
            if (cnt > max) {
                min = sum;
                max = cnt;
            } else if (cnt == max) {
                min = Math.min(min, sum);
            }
            return;
        }

        if ((coreList.size() - depth + cnt) < max) return;
        for (int d = 0; d < delta.length; d++) {
            boolean[][] cloneVisit = clone(visit);
            int tmp = moveDirect(coreList.get(depth), d, cloneVisit);
            if (tmp == 0) dfs(depth + 1, cloneVisit, sum, cnt);
            else dfs(depth + 1, cloneVisit, sum + tmp, cnt + 1);
        }
    }

    static int moveDirect(Core core, int deltaNo, boolean[][] cVisit) {
        int dy = core.y;
        int dx = core.x;
        int cnt = 0;
        while (true) {
            dy += delta[deltaNo][0];
            dx += delta[deltaNo][1];
            if (!isIn(dy, dx)) return cnt;
            if (cVisit[dy][dx] || maps[dy][dx] != 0) return 0;
            cVisit[dy][dx] = true;
            ++cnt;
        }
    }

    static boolean isIn(int y, int x) {
        return (y >= 0 && x >= 0 && y < N && x < N);
    }
}