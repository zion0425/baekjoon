import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[][] arr;
	private static boolean[] isSelected;
	private static int min = 2147483647;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isSelected = new boolean[n];
		rec(0);
		System.out.println(min);
	}

	private static void rec(int d) {
		if (d == n) {
			boolean a = false;
			int sum1 = 1;
			int sum2 = 0;
			for (int i = 0; i < n; i++) {
				if (isSelected[i]) {
					a = true;
					sum1 *= arr[i][0];
					sum2 += arr[i][1];
				}
			}
			if (a) {
				min = Math.min(min, Math.abs(sum2 - sum1));
			}
			return ;
		}
		isSelected[d] = true;
		rec(d + 1);
		isSelected[d] = false;
		rec(d + 1);
	}
}
