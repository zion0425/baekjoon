import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static char[][] cheese;
    private static boolean[][] visit;
    private static int n;
    private static int m;
    private static int meltTime = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cheese = new char[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j ++) {
                cheese[i][j] = st.nextToken().charAt(0);
            }
        }
        int lastMeltCnt = 0;
        while (true) {
            visit = new boolean[n][m];
            int tmp = meltSideCheese();
            if (tmp == 0) break;
            lastMeltCnt = tmp;
            meltTime++;
        }
        sb.append(meltTime).append("\n").append(lastMeltCnt);
        System.out.println(sb);
    }

    private static boolean isIn(int y, int x) {
        return (y >=0 && y < n && x >= 0 && x < m);
    }

    private static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int meltSideCheese() {
        Queue<int []> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});
        int meltCheeseCnt = 0;
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek()[1];
            int y = queue.poll()[0];

            for (int d = 0; d < delta.length; d++) {
                int dy = y + delta[d][0];
                int dx = x + delta[d][1];

                if (isIn(dy, dx) && !visit[dy][dx]) {
                    if (cheese[dy][dx] == '1') {
                        meltCheeseCnt++;
                        cheese[dy][dx] = '0';
                    } else {
                        queue.offer(new int[]{dy, dx});
                    }
                    visit[dy][dx] = true;
                }
            }
        }
        return meltCheeseCnt;
    }
}
