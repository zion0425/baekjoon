import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];

		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {

			for (int j = 1; j < n; j++) {
				arr[i][j] += arr[i][j - 1];
			}
		}

		int[] xy = new int[4];

		for (int t = 1; t <= m; t++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				xy[i] = Integer.parseInt(st.nextToken()) - 1;
			}


			for (int y = xy[0]; y <= xy[2]; y++) {
				if (xy[1] == 0)  {
					sum += arr[y][xy[3]];
					continue;
				}
				sum += arr[y][xy[3]] - arr[y][xy[1] - 1];
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);

	}
}
