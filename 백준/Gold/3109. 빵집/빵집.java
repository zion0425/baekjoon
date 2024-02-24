import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int R;
    private static int C;
    private static int[] deltaY = { -1, 0, 1  };
    private static char[][] map;
    private static int cnt = 0;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visit = new boolean[R][C];
        for (int y = 0; y < R; y++) {
            if (canVisit(y, 1) ) cnt++;
        }

        System.out.println(cnt);
    }

    // return을 안 주면 하나의 경로에서 하나의 긴 파이프를 연결하는것이 아니라, 중간에 파이프를 가지를 펼침
    // 아래와 같은 경우에 파이프를 깐 경로를 1이라고 가정해보자.
    // 1x11
    // .1..
    // .x..
    // 우리가 원하는건 위와 같은 형태인데 delta의 for문이 반복하게 되면서 위와 같은 절차를 한 번 마치고 스택에 남아있던 for문의 delta 로직의 다음을 또 실행
    // 1x11
    // .1.1
    // .x..
    // 그리고 또 아래를 한 번 실행한다.
    // 1x11
    // .111
    // .x.1
    // 이렇게 실행해버리게 된다. 고로, 최종 도착 지점에 도착하게 되면 for문을 종료시킬 방법을 고안해야 한다.

    private static boolean canVisit(int y, int x) {
        if (x == C - 1) {
            return true;
        }
        for (int d = 0; d < deltaY.length; d++) {
            int dy = y + deltaY[d];
            if (isIn(dy, x) && map[dy][x] == '.' && !visit[dy][x]) {
                visit[dy][x] = true;

                if (canVisit(dy, x + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isIn(int y, int x) {
        return (y >= 0 && y < R && x >= 0 && x < C);
    }

}

/*
 *
 * 각 행별로 위에 바짝 붙임 1. 대각위 2. 가로 3. 대각 아래
 *
 * isVisited로 방문 체크 만약 visited[i] = true && map[y][x] == X이면, 방문 불가
 *
 */