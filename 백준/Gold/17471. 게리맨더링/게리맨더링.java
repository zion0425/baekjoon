import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[] peopleCnt;
	private static int n;
	private static boolean[] select;
	private static int[][] contries;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		peopleCnt = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			peopleCnt[i] = Integer.parseInt(st.nextToken());
		}
		contries = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= a; j++) {
				int value = Integer.parseInt(st.nextToken());
				contries[i][value] = contries[value][i] = 1;
			}
		}
		findComb(0, 0);
	}

	private static void findComb(int d, int start) {
		int min = Integer.MAX_VALUE;
		boolean isFind = false;
		for (int i = 1; i < (1 << (n)); i++) {
			int cnt = 0;
			select = new boolean[n + 1];
			for (int j = 0; j < n; j++) {
				if ((i & 1 << j) != 0) {
					select[j + 1] = true;
					cnt++;
				}
			}			
					
			int res1 = bfs(cnt, true);
			int res2 = bfs(n - cnt, false);
			
			if (res1 != -1 && res2 != -1) {
				min = Math.min(Math.abs(res1 - res2), min);
				isFind = true;
			}
		}
		System.out.println(isFind ? min : -1);
	}

	// bfs로 나머지 값들이 연결 가능 여부 확인
	private static int bfs(int cnt, boolean flag) {
		boolean[] visit = new boolean[n + 1];

		Queue<Integer> queue = new ArrayDeque<>();

		int firstFlagCnt = 0;
		int p = 0;

		for (int i = 1; i <= n; i++) {
			if (select[i] == flag) {
				visit[i] = true;
				queue.add(i);
				firstFlagCnt++;
				p += peopleCnt[i];
				break;
			}
		}

		while (!queue.isEmpty()) {
			int curV = queue.poll();

			for (int i = 1; i <= n; i++) {
				if (select[i] == flag && !visit[i] && contries[curV][i] != 0) {
					queue.offer(i);
					visit[i] = true;

					firstFlagCnt++;
					p += peopleCnt[i];
				}
			}
		}

		return firstFlagCnt == cnt ? p : -1;
	}

}
