import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  기본적으로 BFS가 가지치기가 빠르지만,
 *  DFS 도 큰 차이가 없다. (이 문제는 갈림길이 많이 없기 떄문에)
 *  BFS만 푸는 주차를 만들자.
 *  DFS만 푸는 주차를 만들자.
 */

// 배열의 외곽체크를 매번 할 필요 없다는 것을 알아야 한다.
public class Solution {
    private static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int[][] map;
    private static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            map = new int[100][100];
            isVisited = new boolean[100][100];
            int startY = -1;
            int startX = -1;


            for (int i = 0; i < 100; i++) {
                String str = br.readLine(); // 0 길, 1 벽, 2 시작, 3 도착
                for (int j = 0; j < 100; j++) {
                    map[i][j] = str.charAt(j); // 산술연산 안 할거니까 유니코드로 계산
                    // 시작점을 모르면 검색
                    if (map[i][j] == '2') {
                        startY = i;
                        startX = j;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(dfs(startY, startX)).append("\n");

        }
        System.out.println(sb);
    }

    // startY, startX에서 인접칸 탐색, return (도착지점에 갈 수 있다: 1, 없다: 0)
    private static int dfs(int y, int x) {
        if (map[y][x] == '1' || isVisited[y][x]) {
            return 0;
        }
        if (map[y][x] == '3') {
            return 1;
        }
        isVisited[y][x] = true;
        int res = 0;
        for (int d = 0; d < delta.length && res == 0; d++) {
            res = dfs(y + delta[d][0], x + delta[d][1]);
        }
        return res;
    }

}
