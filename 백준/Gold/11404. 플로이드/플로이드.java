import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] DP = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(DP[i], 100000 * 100);
			DP[i][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			DP[s][e] = Math.min(DP[s][e], v);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k][j]);
				}
			}
		}
		print(DP);
	}
	
	private static void print(int[][] DP) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < DP[0].length; i++) {
			for (int j = 1; j < DP.length; j++) {
				if (DP[i][j] >= 100000 * 100) {
					sb.append("0").append(" ");
					continue;
				}
				sb.append(DP[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
