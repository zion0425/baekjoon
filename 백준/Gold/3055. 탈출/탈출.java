import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS 물 - 맵 갱신 BFS 고슴도치
 * 
 * @author SSAFY 물 * 돌 X 도착 D 시작 S
 */
public class Main {

	static char[][] map;
	static int[] e;
	static Queue<int[]> w = new ArrayDeque<>();
	static Queue<int[]> p = new ArrayDeque<>();
	static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static int R;
	private static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = line[j].charAt(0);
				if (map[i][j] == 'D') {
					e = new int[] { i, j };
				} else if (map[i][j] == 'S') {
					p.add(new int[] { i, j });
				} else if (map[i][j] == '*') {
					w.add(new int[] { i, j });
				}
			}
		}
		
		int moveCnt = 0;
		String result;
		while (true) {
			moveCnt++;
			BFS();
			int res = move();
			if ((res != 1)) {
				result = String.valueOf(moveCnt);
				if (res == -1) 
					result = "KAKTUS";
				break;
			}
		}
		System.out.println(result);
	}

	private static void BFS() {
		int waterCnt = w.size();

		for (int i = 0; i < waterCnt; i++) {
			int cy = w.peek()[0];
			int cx = w.poll()[1];

			for (int d = 0; d < delta.length; d++) {
				int dy = cy + delta[d][0];
				int dx = cx + delta[d][1];
				if (isIn(dy, dx) && map[dy][dx] != '*' && map[dy][dx] != 'D' && map[dy][dx] != 'X') {
					map[dy][dx] = '*';
					w.offer(new int[] { dy, dx });
				}
			}
		}

	}

	private static int move() {
		int canMove = -1;
		int pCnt = p.size();
		
		for (int i = 0; i < pCnt; i++) {
			int cy = p.peek()[0];
			int cx = p.poll()[1];
			map[cy][cx] = 's';
			
			for (int d = 0; d < delta.length; d++) {
				int dy = cy + delta[d][0];
				int dx = cx + delta[d][1];
				if (isIn(dy, dx) && map[dy][dx] != 'X' && map[dy][dx] != '*' && map[dy][dx] != 's') {
					if (map[dy][dx] == 'D')
						return 0;
					p.offer(new int[] { dy, dx });
					map[dy][dx] = 's';
					canMove = 1;
				}
			}
		}

		return canMove;
	}

	private static boolean isIn(int y, int x) {
		return (y >= 0 && x >= 0 && y < R && x < C);
	}

}
