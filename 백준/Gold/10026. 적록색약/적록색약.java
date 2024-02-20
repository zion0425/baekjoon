import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static char[][] map;
	private static int n;
	private static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static boolean[][] isVisited;
	private static boolean[][] isVisited2;
	private static int cnt = 0;
	private static int cnt2 = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		isVisited = new boolean[n][n];
		isVisited2 = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!isVisited[i][j]) {
					bfs(i, j, map[i][j]);
					++cnt;
				}
				if (!isVisited2[i][j]) {
					bfs2(i, j, map[i][j]);
					++cnt2;
				}
			}
		}
		System.out.print(cnt + " " + cnt2);
	}

	private static boolean isIn(int y, int x) {
		return (y >= 0 && y < n && x >= 0 && x < n);
	}
	
	private static void bfs2(int y, int x, char curColor) {
		Queue<int []> queue = new LinkedList<>();
		queue.add(new int[]{y, x});
		isVisited2[y][x] = true;
		
		while(!queue.isEmpty()) {
			int curY = queue.peek()[0];
			int curX = queue.poll()[1];
			
			for(int d = 0; d < delta.length; d++) {
				int dy = curY + delta[d][0];
				int dx = curX + delta[d][1];
				
				if(isIn(dy, dx) && !isVisited2[dy][dx] && (map[dy][dx] == curColor || map[dy][dx] + curColor == 'G' + 'R')) {
					isVisited2[dy][dx] = true;
					queue.add(new int[] {dy, dx});
				}
			}
		}
	}

	private static void bfs(int y, int x, char curColor) {
		Queue<int []> queue = new LinkedList<>();
		queue.add(new int[]{y, x});
		isVisited[y][x] = true;
		
		while(!queue.isEmpty()) {
			int curY = queue.peek()[0];
			int curX = queue.poll()[1];
			
			for(int d = 0; d < delta.length; d++) {
				int dy = curY + delta[d][0];
				int dx = curX + delta[d][1];
				
				if(isIn(dy, dx) && map[dy][dx] == curColor && !isVisited[dy][dx]) {
					isVisited[dy][dx] = true;
					queue.add(new int[] {dy, dx});
				}
			}
		}
		

	}
}
