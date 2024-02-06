import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;
	private static int[][] rotateAlpha = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());


		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < r; i++) {
			arr = rotateArr(arr);
		}


		for (int num[] : arr) {
			for (int n : num) {
				System.out.print(n + " ");
			}
			System.out.println();
		}

	}

	private static boolean isIn(int y, int x) {
		return (y < n && y >= 0 && x < m && x >= 0);
	}
	
	private static int[][] rotateArr(int[][] arr) {
		int[][] afterRotateArr = new int[n][m];
		
		int x = 0;
		int y = 0;
		int depth = 0;
		int lastDepth = Math.min(n, m) / 2;
		afterRotateArr = new int[n][m];
		while (depth < lastDepth) {
			for (int d = 0; d < rotateAlpha.length; d++) {
				while (true) {
					int ry = y + rotateAlpha[d][0];
					int rx = x + rotateAlpha[d][1];
					if (!isIn(ry, rx) || afterRotateArr[ry][rx] != 0) {
						break;
					}
					afterRotateArr[y][x] = arr[ry][rx];
					y = ry;
					x = rx;
				}
			}
			afterRotateArr[y][x] = arr[depth][depth];
			y = x = ++depth;
		}
		return afterRotateArr.clone();
	}

}
