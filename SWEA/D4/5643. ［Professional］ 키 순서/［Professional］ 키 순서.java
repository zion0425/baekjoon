import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= tc; t++) {

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            boolean[][] DP = new boolean[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                DP[s][e] = true;
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (DP[i][k] && DP[k][j]) DP[i][j] = true;
                    }
                }
            }

            int res = 0;
            int[] cnt = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (DP[i][j] || DP[j][i])
                        cnt[i]++;
                }
            }
            for (int b :cnt) {
                if (b == n -1) res++;
            }
            sb.append("#").append(t).append(" ").append(res).append("\n");
        }
		System.out.println(sb);
	}
}
