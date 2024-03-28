import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 플로이드 워셜 모든 최단 경로 더한 값을 한 행의 cc로 계산
 * 
 * @author SSAFY
 *
 */

public class Solution {
	private static int MAX = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int[][] DP = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				Arrays.fill(DP[i], MAX);
				for (int j = 1; j <= n; j++) {
					DP[i][j] = Integer.parseInt(st.nextToken());
					if (DP[i][j] == 0) DP[i][j] = MAX;
				}
				DP[i][i] = 0;
			}
						
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k][j]);
					}
				}
			}
			int min = MAX;
			for (int i = 1; i <= n; i++) {
				int cur = 0;
				for (int j = 1; j <= n ; j++) {
					cur += DP[i][j];
				}
				min = Math.min(min, cur);
			}

			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);

	}
}
