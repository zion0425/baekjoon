import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, W, H;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map;
	static int max;
	private static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int totalCount;
	
	public static void main(String[] args) throws IOException {
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			totalCount = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			max = Integer.MIN_VALUE;
			input();
			findComb(0, 0, map);
			max = totalCount - max;
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static void input() throws IOException{
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					totalCount++;
				}
			}
		}
	}
	
	public static int[][] cloneMap(int[][] map) {
		int[][] newMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}

	public static int findBrokeCoor(int w, int[][] map) {
		int res = -1;
		for (int i = 0; i < H; i++) {
			if (map[i][w] != 0) {
				res = i;
				break;
			}
		}
		return res;
	}

	// 벽돌 놓는 위치 경우의 수 DFS
	public static void findComb(int d, int brokeCnt, int[][] _map) {
		max = Math.max(brokeCnt, max);

		if (d == N) {
			
			return;
		}
		for (int i = 0; i < W; i++) {
			int[][] cloneMap = cloneMap(_map);
			int y = findBrokeCoor(i, cloneMap);
			if (y == -1) continue;
			int tmpCnt = breakWall(y, i, cloneMap[y][i], cloneMap);
			moveMap(cloneMap);
			findComb(d + 1, brokeCnt + tmpCnt, cloneMap);
		}
	}

	// 벽둘 부시기
	public static int breakWall(int y, int x, int b, int[][] map) {
		int breakCount = 0;

		if (map[y][x] != 0)
			breakCount = 1;
		map[y][x] = 0;
		for (int i = 1; i < b; i++) {
			for (int d = 0; d < delta.length; d++) {
				int dy = y + delta[d][0] * i;
				int dx = x + delta[d][1] * i;
				
				if (isIn(dy, dx) && map[dy][dx] != 0) {
					int res = breakWall(dy, dx, map[dy][dx], map);
					breakCount+=res;
				}
			}
		}

		return breakCount;
	}
	
	public static void moveMap(int G[][]) { 
        for (int j = 0; j < W; j++) {
            int cnt = 0;
            for (int i = H - 1; i >= 0; i--) {
                if (G[i][j] == 0) {
                    cnt += 1;
                } else if (cnt > 0) {
                    G[i + cnt][j] = G[i][j];
                    G[i][j] = 0;
                }
            }
        }


	}

	public static boolean isIn(int y, int x) {
		return (y >= 0 && x >= 0 && x < W && y < H);
	}
}
