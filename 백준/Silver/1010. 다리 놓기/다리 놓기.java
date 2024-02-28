import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] DP = new int[M + 1][N + 1];

			for (int i = 0; i <= M; i++) {
				for (int j = 0; j <= Math.min(i, N); j++) {
					if (j == 0 || i == j) 
						DP[i][j] = 1;
					else
						DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j]; 
				}
				
			}
			System.out.println(DP[M][N]);
		}
	}
}

