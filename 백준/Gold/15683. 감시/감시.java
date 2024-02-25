import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * cctv의 방향 조합을 모두 구한다.
 * cctv 클래스를 저장할 ArrayList
 * dfs로 cctv의 각 모든 방향 경우의 수 재귀
 * delta로 각 타입별 cctv 감시 방향 설정 [x: 너무 많음]
 * -> 함수로 제어 (4가지 방향을 살펴보는 함수 만든 뒤 --> 한 가지 방향만을 보고, 인자로 0, 1 1, 0 이런식으로 y x 넘겨줌
 */
public class Main {

    static class CCTV {
        int y, x, type;

        public CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    static int n, m;
    static int[][] map;
    static ArrayList<CCTV> cctvList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        inputs();
        boolean[][] visit = new boolean[n][m];
        dfs(0, visit);
        System.out.println(min);
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
    }
    private static int min = Integer.MAX_VALUE;
    public static void dfs(int d, boolean[][] visit) {
        if (d == cctvList.size()) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)  {
                    if (!visit[i][j] && map[i][j] != 6)
                        sum++;
                }
            }
            sum -= cctvList.size();
            min = Math.min(min, sum);
            return ;
        }
        for (int i = 1; i <= 4; i++) {
            // 방향 설정 위 오른 아래 왼
            boolean[][] cloned = cloneVisit(visit);
            monitor(cctvList.get(d), i, cloned);
            dfs(d + 1, cloned);
        }
    }

    private static boolean[][] cloneVisit(boolean[][] visit) {
        boolean[][] cloneVisit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cloneVisit[i][j] = visit[i][j];
            }
        }
        return cloneVisit;
    }

    public static void monitor(CCTV cctv, int direction, boolean[][] cloneVisit) {
        switch (cctv.type) {
            case 1:
                if (direction == 1) {
                    detect(-1, 0, cctv, cloneVisit);
                } else if (direction == 2) {
                    detect(0, 1, cctv, cloneVisit);
                } else if (direction == 3) {
                    detect(1, 0, cctv, cloneVisit);
                } else if (direction == 4) {
                    detect(0, -1, cctv, cloneVisit);
                }
                break;
            case 2:
                if (direction == 1 || direction == 3) {
                    detect(1, 0, cctv, cloneVisit);
                    detect(-1, 0, cctv, cloneVisit);
                } else if (direction == 2 || direction == 4) {
                    detect(0, -1, cctv, cloneVisit);
                    detect(0, 1, cctv, cloneVisit);
                }
                break;
            case 3:
                if (direction == 1) {
                    detect(-1, 0, cctv, cloneVisit);
                    detect(0, 1, cctv, cloneVisit);
                } else if (direction == 2) {
                    detect(1, 0, cctv, cloneVisit);
                    detect(0, 1, cctv, cloneVisit);
                } else if (direction == 3) {
                    detect(1, 0, cctv, cloneVisit);
                    detect(0, -1, cctv, cloneVisit);
                } else if (direction == 4) {
                    detect(-1, 0, cctv, cloneVisit);
                    detect(0, -1, cctv, cloneVisit);
                }
                break;
            case 4:
                if (direction == 1) {
                    detect(-1, 0, cctv, cloneVisit);
                    detect(0, 1, cctv, cloneVisit);
                    detect(0, -1, cctv, cloneVisit);
                } else if (direction == 2) {
                    detect(-1, 0, cctv, cloneVisit);
                    detect(1, 0, cctv, cloneVisit);
                    detect(0, 1, cctv, cloneVisit);
                } else if (direction == 3) {
                    detect(1, 0, cctv, cloneVisit);
                    detect(0, 1, cctv, cloneVisit);
                    detect(0, -1, cctv, cloneVisit);
                } else if (direction == 4) {
                    detect(1, 0, cctv, cloneVisit);
                    detect(-1, 0, cctv, cloneVisit);
                    detect(0, -1, cctv, cloneVisit);
                }
                break;
            case 5:
                detect(1, 0, cctv, cloneVisit);
                detect(-1, 0, cctv, cloneVisit);
                detect(0, -1, cctv, cloneVisit);
                detect(0, 1, cctv, cloneVisit);
        }
    }

    public static void detect(int y, int x, CCTV cctv,  boolean[][] cloneVisit) {
        int dy = cctv.y + y;
        int dx = cctv.x + x;
        while (canMonitor(dy, dx)) {
            if (map[dy][dx] == 0) {
                cloneVisit[dy][dx] = true;
            }
            dy += y;
            dx += x;
        }
    }

    private static boolean canMonitor(int y, int x) {
        return (y >= 0 && y < n && x >= 0 && x < m && map[y][x] != 6);
    }
}
