import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static boolean[] visit;
	private static int[][] nodeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n];
		
		nodeList = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				nodeList[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		arr = new int[n];
		dfs(0);
		System.out.println(min);
	}
	
	static long min = Integer.MAX_VALUE;
	private static int[] arr;
	public static void dfs(int d) {
		if (d == n) {
			int tmp = 0; 
			int i;
			for (i = 0; i < n - 1; i++) {
				if (nodeList[arr[i]][arr[i + 1]] == 0) return;
				tmp += nodeList[arr[i]][arr[i + 1]];
			}
			if (nodeList[arr[i]][arr[0]] == 0) return;
			tmp += nodeList[arr[i]][arr[0]];
			min = Math.min(tmp, min);
			return ;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				arr[d] = i; 
				visit[i] = true;
				dfs(d + 1);
				visit[i] = false;
			}
		}
	}

}
