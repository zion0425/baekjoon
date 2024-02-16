import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static boolean[][] matrix;
	private static int N;
	private static int M;
	private static int V;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
	
		matrix = new boolean[N + 1][N + 1];
		isVisited = new boolean[N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = matrix[to][from] = true;
			
		}
		dfs(V);
		isVisited = new boolean[N + 1];
		System.out.println();
		bfs(V);
	}

	private static boolean[] isVisited;
	
	private static void dfs(int cur) {
		System.out.print(cur + " ");
		isVisited[cur] = true;
		for (int j = 1; j <= N; j++) {
			if (matrix[cur][j] && !isVisited[j]) {
				dfs(j);
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.add(start);
		isVisited[start] = true;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			
			for (int i = 1; i <= N; i++) {
				if (matrix[cur][i] && !isVisited[i]) {
					queue.offer(i);
					isVisited[i] = true;
				}
			}
			
		}
		
	}
}
