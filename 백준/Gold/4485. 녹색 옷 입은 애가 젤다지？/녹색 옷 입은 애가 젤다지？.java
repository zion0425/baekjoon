import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static PriorityQueue<Pos> q;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] map;
	static boolean[][] visit;

	static class Pos implements Comparable<Pos> {
		int y, x, value;

		public Pos(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}

		
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.value, o.value);
		}
	}

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int idx = 0;
		while (true ) {
			q = new PriorityQueue<>();
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;

			map = new int[n][n];
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			q.add(new Pos(0, 0, map[0][0]));
			
			while (!q.isEmpty() ) {
				if (q.peek().y == n - 1 && q.peek().x == n -1) {
					break;
				}
				int y = q.peek().y;
				int x = q.peek().x;
				int v = q.poll().value;
				
				for (int d = 0; d < delta.length; d++) {
					int dy = delta[d][0] + y;
					int dx = delta[d][1] + x;
					if (isIn(dy, dx) && !visit[dy][dx]) {
						q.add(new Pos(dy, dx, v + map[dy][dx]));
						visit[dy][dx] = true;
					}
				}
				
			}
			sb.append("Problem ").append(++idx).append(": ").append(q.poll().value).append("\n");
		}
		System.out.println(sb);
	}

	static boolean isIn(int y, int x) {
		return (y >= 0 && x >= 0 && x < n && y < n);
	}

}
