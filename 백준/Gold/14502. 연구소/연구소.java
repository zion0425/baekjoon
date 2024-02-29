import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	private static int n;
	private static int m;
	private static ArrayList<Virus> virusList = new ArrayList<>();
	private static int totalZeroCnt = -3;
	private static int max = 0;
	
	static class Virus {
		int y, x;

		public Virus(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					totalZeroCnt++;
				} else if (map[i][j] == 2) {
					virusList.add(new Virus(i, j));
				}
			}
		}
//		System.out.println(totalZeroCnt);
		// 6중 포문..?
		for (int i = 0; i < n * m - 2; i++) {
			if (map[i / m][i % m] != 0) continue;
			
			for (int j = i + 1; j < n * m - 1; j++) {
				if (map[j / m][j % m] != 0) continue;
				
				for (int k = j + 1; k < n * m; k++) {
					if (map[k / m][k % m] != 0) continue;
					
					map[i / m][i % m] = 1;
					map[j / m][j % m] = 1;
					map[k / m][k % m] = 1;
					dfs();
					map[k / m][k % m] = 0;
					map[j / m][j % m] = 0;
					map[i / m][i % m] = 0;
			
				}
			}
		}
//		System.out.println(totalZeroCnt);

		System.out.println(max);
	}
	
	static int[][] delta = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
		
	static void dfs() {
		boolean[][] visit = new boolean[n][m];
		int cnt = 0;
		
		for (int i = 0; i < virusList.size(); i++) {
			Queue<int[]> queue = new ArrayDeque<>();
			
			int sY = virusList.get(i).y;
			int sX = virusList.get(i).x;
			queue.add(new int[] {sY, sX});
 			
			while (!queue.isEmpty()) {
				int curY = queue.peek()[0];
				int curX = queue.poll()[1];

				for (int d = 0 ; d < delta.length; d++) {
					int dy = curY + delta[d][0];
					int dx = curX + delta[d][1];
					
					if (canMove(dy, dx) && !visit[dy][dx]) {
						queue.offer(new int[] {dy, dx});
						visit[dy][dx] = true;
						cnt ++;
					}
				}
			}
//			for (boolean[] a :visit) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println(totalZeroCnt - cnt);
		}

//		System.out.println();
		
//		System.out.println(cnt);
		max = Math.max(max, totalZeroCnt - cnt);
	}
	
	static boolean canMove(int y, int x) {
		return (y >= 0 && x >= 0 && y < n && x < m && map[y][x] == 0);
	}
}
