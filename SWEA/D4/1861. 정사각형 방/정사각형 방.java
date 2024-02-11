import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

	private static int[][] delta = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
	private static int n;
	private static int max;
	private static int cnt;
	private static boolean[][] isVisited;
	private static int[][] rooms;
	private static int smallPoint = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			n = Integer.parseInt(br.readLine());
			rooms = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					cnt = 0;
					isVisited = new boolean[n][n];
					visitRoom(y, x);
					if (max == cnt) {
						if (smallPoint > rooms[y][x])
							smallPoint = rooms[y][x];
					} else if (max <= cnt) {
						smallPoint = rooms[y][x];
					}
 					max  = Math.max(max, cnt);

					
				}
			}	
			System.out.println("#" + t + " " +smallPoint + " " + (max + 1));
		}

	}

	private static boolean isIn(int x, int y) {
		return (0 <= y && y < n && x >= 0 && x < n);
	}
	
	private static void visitRoom(int y, int x) {
		for (int d = 0; d < delta.length; d++) {
			int rx = x + delta[d][1];
			int ry = y + delta[d][0];
			if (isIn(rx, ry) && !isVisited[y][x] && rooms[ry][rx] - rooms[y][x] == 1) {
				cnt++;
				visitRoom(ry, rx);
			}
		}
	}

}

