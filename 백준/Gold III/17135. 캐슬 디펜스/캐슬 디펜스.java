import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static Arc[] arcs;

	private static int N;
	private static int M;
	private static int D;

	private static int[][] map;

	public static void main(String[] args) throws IOException {
		inputs();
		System.out.println(max);
	}

	private static void inputs() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		play();

	}

	private static void play() {
		setPosition();
	}
	static int max = 0;
	private static int[][] tmpMap;
	
	private static void setPosition() {
		arcs = new Arc[3];
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				for (int k = j + 1; k < M; k++) {
					int cnt = 0;
					cloneMap();
					arcs[0] = new Arc(i);
					arcs[1] = new Arc(j);
					arcs[2] = new Arc(k);
					
					for (int s = 0; s < N; s++) {
						for (int l = 0; l < 3; l++) {
							findKillableEnemy(arcs[l]);
						}
						for (int l = 0; l < 3 && !enemyQueue.isEmpty(); l++) {
							Integer[] tmp = enemyQueue.poll();
							if (tmpMap[tmp[0]][tmp[1]] == 1) {
								tmpMap[tmp[0]][tmp[1]] = 0;
								cnt++;
							}
						}
						moveArc();
					}
					max = Math.max(max, cnt);
				}
			}
		}
	}

	static ArrayDeque<Integer[]> queue = new ArrayDeque<>();
	static ArrayDeque<Integer[]> enemyQueue = new ArrayDeque<>();
	static int[][] delta = { { 0, -1 }, { -1, 0 }, { 0, 1 } };

	private static void cloneMap() {
		tmpMap = new int[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}
	}
	// bfs로 탐색 죽일 수 있는 적 탐색
	private static void findKillableEnemy(Arc arc) {
		// 죽일 수 있는 적의 좌표를 저장하는 큐
		Queue<Integer[]> queue = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N + 1][M];
		boolean isFind = false; 

		queue.offer(new Integer[]{arc.y, arc.x});
		isVisited[arc.y][arc.x] = true;

		for (int i = 0; i < D && !isFind; i++) {	
			while (!queue.isEmpty() && !isFind) {
				Integer[] temp = queue.poll();
				int curY = temp[0];
				int curX = temp[1];
				
				for (int d = 0; d < delta.length; d++) {
					int dy = curY + delta[d][0];
					int dx = curX + delta[d][1];
					if (isIn(dy, dx) && !isVisited[dy][dx]) {
						if (tmpMap[dy][dx] == 1 && arc.canShoot(dy, dx)) {
							// queue에 좌표값 저장
							enemyQueue.offer(new Integer[]{dy, dx});
							isFind = true;
							break;
						}
						queue.offer(new Integer[] {dy, dx});
						isVisited[dy][dx] = true;
					}
				}
			}
		}
		
		
	}
	
	private static boolean isIn(int y, int x) {
		return (y >= 0 && y < N && x >= 0 && x < M);
	}

	public static void moveArc() {
		for (int i = 0; i < 3; i++) {
			arcs[i].moveUp();
		}
	}

	static class Arc {
		private int x;
		private int y;

		public Arc(int x) {
			this.x = x;
			this.y = N;
		}

		public boolean canShoot(int targetY, int targetX) {
			return (D >= Math.abs(targetY - y) + Math.abs(targetX - x)) && (targetY < y);
		}

		public void moveUp() {
			--y;
		}
	}
}