import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int R;
    private static int C;
    private static boolean[] isVisited;
    private static int[][] alphaMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 알파벳 A 부터 Z 까지 인덱스에 매핑
        isVisited = new boolean[26];
        alphaMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                alphaMap[i][j] = str.charAt(j) - 65;
            }
        }
        dfs(0, 0, 0);
        System.out.println(max);
    }

    private static boolean isIn(int y, int x) {
        return (x >= 0 && x < C && y >= 0 && y < R);
    }

    private static int max = 1;
    private static void dfs(int y, int x, int cnt) {
        if (isVisited[alphaMap[y][x]]) {
            max = Math.max(max, cnt);
            return;
        }
        isVisited[alphaMap[y][x]] = true;
        if (isIn(y + 1, x)) dfs(y + 1, x, cnt + 1);
        if (isIn(y - 1, x)) dfs(y - 1, x, cnt + 1);
        if (isIn(y, x + 1)) dfs(y, x + 1, cnt + 1);
        if (isIn(y, x - 1)) dfs(y, x - 1, cnt + 1);
        isVisited[alphaMap[y][x]] = false;
    }

}
