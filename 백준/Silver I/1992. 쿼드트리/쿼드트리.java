import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int[][] map;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st[j]);
            }
        }
        isVisited = new boolean[n + 1];
        press(0, 0, n);
        System.out.println(sb);

    }

    private static boolean[] isVisited;
    private static void press(int x, int y, int size) {
        int res = isSame(x, y, size);
        if (size == 0) {
            return;
        }
        if (res != -1) {
            sb.append(res);
            return;
        }
        if (!isVisited[size])
            sb.append("(");
        isVisited[size] = true;
        press(x, y, size / 2);
        press(x + size / 2, y, size / 2);
        press(x, y + size / 2, size / 2);
        press(x + size / 2, y + size / 2, size / 2);
        if (isVisited[size])
            sb.append(")");
        isVisited[size] = false;
    }

    private static int isSame(int x, int y, int size) {
        int prev = map[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != prev) {
                    return -1;
                }
                prev = map[i][j];
            }
        }
        return prev;
    }

}

/*

현재 모든게 다 똑같은가?
 맞다 sb.append(현재 숫자)
 아니면 4분할

현재 모든게 다 똑같은가?

 */