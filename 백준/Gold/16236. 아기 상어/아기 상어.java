import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * n * n 크기 M 마리의 아기상어 1마리
 * 
 * 아기상어 크기 2 1초에 상하좌우 1칸씩 아기상어 몸집 < 큰 물고기 : 못지나감 작은 물고기만
 * 
 * 먹을 수 있는 물고기 중 거리가 가장 가까운 물고기먹음 거리가 동일하면 왼쪽 위 부터 먹음
 * 
 * @author SSAFY
 *
 */
public class Main {

	static int N;
	static int[][] map;

	static class Fish implements Comparable<Fish> {
		int y, x, size;

		public Fish(int y, int x, int size) {
			this.y = y;
			this.x = x;
			this.size = size;
		}

		@Override
		public int compareTo(Fish o) {
			return (o.y == o.y) ? Integer.compare(this.x, o.x) : Integer.compare(o.y, this.y);
		}
	}

	static class Me extends Fish {
		int eatCnt = size;

		public Me(int y, int x, int size) {
			super(y, x, size);
		}

	}

	// 동일 거리에 있는 먹이 중 먹는 우선순위에 따른 delta 정렬 (좌 상 우 하)
	static int[][] delta = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	private static ArrayList<Fish> fish;
	private static Me me;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		fish = new ArrayList<>();
		map = new int[N][N];

		// inputs
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					me = new Me(i, j, 2);
				} else if (map[i][j] != 0) {
					fish.add(new Fish(i, j, map[i][j]));
				}
			}
		}

		// 어항에 물고기가 없을 경우
		if (fish.size() == 0) {
			System.out.println(0);
			return;
		}
		// find
		int tmp = -1;
		while (tmp != 0) {
			tmp = find();
//			System.out.println(tmp);
			distance += tmp;
		}

		System.out.println(distance);

	}

	private static boolean isIn(int y, int x) {
		return (y >= 0 && y < N && x >= 0 && x < N);
	}

	static int distance;

	private static int find() {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		PriorityQueue<int[]> fQueue = new PriorityQueue<>((o1, o2) -> {
			return (o1[0] == o2[0]) ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]);
		});
		
		boolean[][] visit = new boolean[N][N];
		queue.add(new int[] { me.y, me.x });
		visit[me.y][me.x] = true;


		while (!queue.isEmpty()) {
			cnt++;
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int cy = queue.peek()[0];
				int cx = queue.poll()[1];

				visit[cy][cx] = true;
				
				for (int d = 0; d < delta.length; d++) {
					int dy = cy + delta[d][0];
					int dx = cx + delta[d][1];

					if (isIn(dy, dx) && !visit[dy][dx] && map[dy][dx] <= me.size) {
						if (map[dy][dx] != 0 && map[dy][dx] < me.size)
							fQueue.offer(new int[] { dy, dx });
						queue.offer(new int[] { dy, dx });
						visit[dy][dx] = true;
					}
				}

			}
			
			while (!fQueue.isEmpty()) {
				int dy = fQueue.peek()[0];
				int dx = fQueue.poll()[1];

				if (--me.eatCnt == 0) {
					me.eatCnt = ++me.size;
				}

				map[me.y][me.x]= 0;
				me.y = dy;
				me.x = dx;
				map[dy][dx] = 0;
				
				return cnt;
			}
		}
		return 0;
	}

}
